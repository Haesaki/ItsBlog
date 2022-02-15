package org.sincq.itsblog.service.Impl;

import org.sincq.itsblog.dao.BlogMapper;
import org.sincq.itsblog.dao.CommentMapper;
import org.sincq.itsblog.entity.Comment;
import org.sincq.itsblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private BlogMapper blogMapper;

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplays = new ArrayList<>();

    @Override
    public List<Comment> listCommentByBlogId(Integer blogId) {
        //查询出父节点
        List<Comment> comments = commentMapper.findByBlogIdParentIdNull(blogId, Integer.parseInt("-1"));
        for(Comment comment : comments){
            Integer id = comment.getId();
            String parentNickname1 = comment.getNickname();
            List<Comment> childComments = commentMapper.findByBlogIdParentIdNotNull(blogId,id);
//            查询出子评论
            combineChildren(blogId, childComments, parentNickname1);
            comment.setReplyComments(tempReplays);
            tempReplays = new ArrayList<>();
        }
        return comments;
    }

    private void combineChildren(Integer blogId, List<Comment> childComments, String parentNickname1) {
//        判断是否有一级子评论
        if(childComments.size() > 0){
//                循环找出子评论的id
            for(Comment childComment : childComments){
                String parentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname1);
                tempReplays.add(childComment);
                Integer childId = childComment.getId();
//                    查询出子二级评论
                recursively(blogId, childId, parentNickname);
            }
        }
    }

    private void recursively(Integer blogId, Integer childId, String parentNickname1) {
//        根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentMapper.findByBlogIdAndReplayId(blogId,childId);

        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Integer replayId = replayComment.getId();
                tempReplays.add(replayComment);
                recursively(blogId,replayId,parentNickname);
            }
        }
    }

    @Override
    public int saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        int comments = commentMapper.saveComment(comment);
        blogMapper.updateCommentCountById(comment.getBlogId());
        return comments;
    }

    @Override
    public void deleteComment(Comment comment,Integer id) {
        commentMapper.deleteComment(id);
        blogMapper.updateCommentCountById(comment.getBlogId());
    }
}
