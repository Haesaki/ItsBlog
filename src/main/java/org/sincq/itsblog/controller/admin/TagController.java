package org.sincq.itsblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TagController {
    @GetMapping("admin/tag")
    public String tag(){
        return "admin/blogTag";
    }
}
