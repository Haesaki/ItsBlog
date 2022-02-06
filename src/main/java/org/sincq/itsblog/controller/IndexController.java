package org.sincq.itsblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sincq.itsblog.entity.Blog;
import org.sincq.itsblog.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index() {
        return "index";
    }

//    @GetMapping("/index")
//    public String getIndex(){
//        return "index";
//    }

    @GetMapping("/index")
    public String listBlogs(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        String orderBy = "updateTime desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Blog> list = blogService.listAllBlog();
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "index";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/tag")
    public String tags() {
        return "tags";
    }

    @GetMapping("/about")
    public String aboutme() {
        return "aboutme";
    }

//    @GetMapping("/type")
//    public String types(){
//        return "types";
//    }

    @GetMapping("/archive")
    public String archive() {
        return "archives";
    }
}
