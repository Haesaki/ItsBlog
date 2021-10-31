package org.sincq.itsblog.web;

import org.sincq.itsblog.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
    private final Logger logger  = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index(){
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

    @GetMapping("/type")
    public String types(){
        return "types";
    }

    @GetMapping("/archive")
    public String archive(){
        return "archive";
    }

    @GetMapping("/blogPublish")
    public String blogPublish(){
        return "/admin/blogPublish";
    }
}
