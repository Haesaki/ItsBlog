package org.sincq.itsblog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sincq.itsblog.entity.Blog;
import org.sincq.itsblog.entity.Type;
import org.sincq.itsblog.entity.User;
import org.sincq.itsblog.service.Impl.BlogServiceImpl;
import org.sincq.itsblog.service.Impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private TypeServiceImpl typeService;

    // list of blogs
    @RequestMapping("admin/blog")
    public String listBlogs(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        String orderBy = "updateTime desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Blog> list = blogService.listAllBlog();
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("pageInfo", pageInfo);
        return "admin/blogAdmin";
    }

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
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());

        blog.setViews(0);

//        blog.setTypeName(typeService.getTypeById(blog.getTypeId()).getName());

        int ret = blogService.saveBlog(blog);
        if(ret == 0){
            attributes.addAttribute("message", "????????????");
        }else{
            attributes.addAttribute("message", "????????????");
        }
        return "redirect:/admin/blog";
    }

    // delete blog
    @GetMapping("admin/blog/{id}/delete")
    // http://127.0.0.1:8080/admin/blog/1/delete
    public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message", "????????????");
        return "redirect:/admin/blog";
    }

    // to edit the blog
    @GetMapping("admin/blog/{id}/input")
    public String editInput(@PathVariable Integer id, Model model) {
        Blog blog = blogService.getBlog(id);
        List<Type> entireType = typeService.getAllType();
        model.addAttribute("blog", blog);
        model.addAttribute("types", entireType);
        return "admin/blogPublish";
    }

    // ??????????????????
    @PostMapping("admin/blog/{id}")
    public String editPost(@NonNull Blog blog, RedirectAttributes attributes) {
        int b = blogService.updateBlog(blog.getId(), blog);
        if(b ==0){
            attributes.addFlashAttribute("message", "????????????");
        }else {
            attributes.addFlashAttribute("message", "????????????");
        }
        return "redirect:/admin/blog";
    }

    // ????????????
//    @PostMapping("admin/blog/search")
//    public String search(Blog blog, Model model,
//                         @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
//        List<Blog> blogBySearch = blogService.getBlogBySearch(searchBlog);
//        PageHelper.startPage(pageNum, 10);
//        PageInfo<Blog> pageInfo = new PageInfo<>(blogBySearch);
//        model.addAttribute("pageInfo", pageInfo);
//        return "redirect:/admin/blog";
//    }
}
