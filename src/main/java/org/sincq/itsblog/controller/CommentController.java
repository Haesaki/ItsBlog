package org.sincq.itsblog.controller;

import org.sincq.itsblog.entity.Blog;
import org.sincq.itsblog.entity.Comment;
import org.sincq.itsblog.entity.User;
import org.sincq.itsblog.service.BlogService;
import org.sincq.itsblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

//    @Value("${Comment.avatar}")
//    private String avatar = "https://unsplash.it/100/100?image=1005";

    //    查询评论列表
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Integer blogId, Model model) {
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
//        return "blog/" + String.valueOf(blogId);
        return "blog :: commentList";
    }

    //    新增评论
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session, Model model) {
        if(comment.getContent().length() > 1024){
            model.addAttribute("msg", "too long comment");
            return "";
        }
        Integer blogId = comment.getBlogId();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            //设置头像
            comment.setAvatar("https://unsplash.it/100/100?image=1001");
        }

        if (comment.getParentComment().getId() != null) {
            comment.setParentCommentId(comment.getParentComment().getId());
        }
        commentService.saveComment(comment);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }

    //    删除评论
    @GetMapping("/comment/{blogId}/{id}/delete")
    public String delete(@PathVariable Integer blogId, @PathVariable Integer id, Comment comment, RedirectAttributes attributes, Model model) {
        commentService.deleteComment(comment, id);
        Blog blog = blogService.getBlog(blogId);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("blog", blog);
        model.addAttribute("comments", comments);
        return "blog/" + String.valueOf(blogId);
    }
}