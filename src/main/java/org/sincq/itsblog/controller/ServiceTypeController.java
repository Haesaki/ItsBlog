package org.sincq.itsblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sincq.itsblog.entity.Blog;
import org.sincq.itsblog.entity.Type;
import org.sincq.itsblog.service.BlogService;
import org.sincq.itsblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ServiceTypeController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    // 分页查询分类
    @GetMapping("/type/{id}")
    public String types(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @PathVariable Integer id, Model model) {
        List<Type> types = typeService.getAllType();
        // System.out.println("types:"+types);
        //-1表示从首页导航点进来的
        if (id == -1) {
            id = types.get(0).getId();
        }
        model.addAttribute("types", types);
        PageHelper.startPage(pageNum, 50);
        List<Blog> blogs = blogService.getByTypeId(id);
        for (Blog blog : blogs) {
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

        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTypeId", id);
        return "type";
    }
}
