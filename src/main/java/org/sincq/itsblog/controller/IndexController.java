package org.sincq.itsblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final Logger logger  = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }

    @GetMapping("/tag")
    public String tags(){
        return "tags";
    }

//    @GetMapping("/type")
//    public String types(){
//        return "types";
//    }

    @GetMapping("/archive")
    public String archive(){
        return "archives";
    }

    @GetMapping("/blogPublish")
    public String blogPublish(){
        return "admin/blogPublish";
    }

    @GetMapping("admin/blog")
    public String adminblog(){
        return "admin/blogAdmin";
    }

    @GetMapping("admin/tag")
    public String tag(){
        return "admin/blogTag";
    }
}
