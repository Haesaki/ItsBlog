package org.sincq.itsblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sincq.itsblog.entity.Blog;
import org.sincq.itsblog.service.BlogService;
import org.sincq.itsblog.util.MarkdownUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        String orderBy = "updateTime desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Blog> list = blogService.listAllBlog();
        for (Blog blog : list) {
            String content = blog.getContent();
            StringBuilder sb = new StringBuilder();
            for (char ch : content.toCharArray()) {
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
                        || ch == '.' || ch == '!' || ch == '。' || ch == '！'
                        || ch == '?' || ch == '？' || ch == ' ') {
                    sb.append(ch);
                    if (sb.length() > 100) {
                        break;
                    }
                } else if (ch == '\n') {
                    sb.append(" ");
                }
            }
            sb.append(".....");
            blog.setContent(sb.toString());
        }
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "index";
    }

    @GetMapping("/index")
    public String listBlogs(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        String orderBy = "updateTime desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Blog> list = blogService.listAllBlog();
        for (Blog blog : list) {
            String content = blog.getContent();
            StringBuilder sb = new StringBuilder();
            for (char ch : content.toCharArray()) {
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
                        || ch == '.' || ch == '!' || ch == '。' || ch == '！'
                        || ch == '?' || ch == '？' || ch == ' ') {
                    sb.append(ch);
                    if (sb.length() > 100) {
                        break;
                    }
                } else if (ch == '\n') {
                    sb.append(" ");
                }
            }
            sb.append(".....");
            blog.setContent(sb.toString());
        }
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "index";
    }

    //搜索博客
    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                         @RequestParam String query) {
        PageHelper.startPage(pageNum, 1000);
        List<Blog> searchBlog = blogService.getSearchBlog(query);

        PageInfo<Blog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Integer id, Model model) {
        Blog blog = blogService.getBlog(id);
        blog.setContent(MarkdownUtil.markdown2HtmlExtensions(blog.getContent()));
        model.addAttribute("blog", blog);
        return "blog";
    }

    @GetMapping("/aboutme")
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
