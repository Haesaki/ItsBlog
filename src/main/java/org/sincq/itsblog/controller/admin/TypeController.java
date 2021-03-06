package org.sincq.itsblog.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sincq.itsblog.entity.Type;
import org.sincq.itsblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/admin")
public class TypeController {
    @Autowired
    TypeService typeService;

    @GetMapping("/admin/type")
    public String list(Model model,
                       @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 10);
        List<Type> list = typeService.getAllType();
        PageInfo<Type> pageInfo = new PageInfo<>(list);
//        System.out.println(pageInfo.getPageNum());
//        System.out.println(pageInfo.getPageSize());
        model.addAttribute("pageInfo", pageInfo);
        return "admin/blogType";
    }

    @GetMapping("/admin/type/input")
    public String input(Model model){
        model.addAttribute("type", new Type());
        return "admin/blogTypeInput";
    }

    // add new Types
    @PostMapping("/admin/type")
    public String postTypes(Type type, RedirectAttributes attributes){
        if("".equals(type.getName())){
            attributes.addAttribute("message", "不能添加非空!");
            return "redirect:admin/type/input";
        }
        if(!typeService.insertType(type)){
            attributes.addFlashAttribute("message", "新增失败，不能添加重复的分类");
            return "redirect:admin/type/input";
        }
        return "redirect:/admin/type";
    }

    @GetMapping("/admin/type/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
        typeService.deleteTypeById(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/type";
    }
}
