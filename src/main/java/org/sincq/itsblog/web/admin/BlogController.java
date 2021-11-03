package org.sincq.itsblog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogController {
    @GetMapping("/blog")
    public String blogs(){
        return "/admin/blogAdmin";
    }

    @GetMapping("type")
    public String type(){
        return "/admin/blogType";
    }

    @GetMapping("/tag")
    public String tag(){
        return "/admin/blogTag";
    }
}
