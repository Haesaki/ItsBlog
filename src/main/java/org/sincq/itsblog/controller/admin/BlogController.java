package org.sincq.itsblog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sincq.itsblog.entity.Blog;
import org.sincq.itsblog.entity.User;
import org.sincq.itsblog.service.BlogService;
import org.sincq.itsblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    // go to the create blog page
    @GetMapping("admin/blog/input")
    public String crateBlog(Model model){
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("blog", new Blog());
        return "admin/blogPublish";
    }

    // create new blog
    @PostMapping("admin/blog")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
        User user = (User) session.getAttribute("user");
        blog.setUserName(user.getUsername());
        blog.setTypeName(typeService.getTypeById(blog.getTypeId()).getName());

        int ret = blogService.saveBlog(blog);
        if(ret == 0){
            attributes.addAttribute("message", "增加失败");
        }else{
            attributes.addAttribute("message", "新增成功");
        }
        return "redirect:/admin/blogAdmin";
    }

    // list of blogs
    @RequestMapping("admin/blog")
    public String listBlogs(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Blog> blogList = blogService.listAllBlog();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("pageInfo", pageInfo);
        return "admin/blogAdmin";
    }
}
