package org.sincq.itsblog.web.admin;

import org.sincq.itsblog.entity.User;
import org.sincq.itsblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    UserService userService;

    // 拦截所有请求
    @GetMapping
    public String loginPage(HttpServletRequest request) {
        if(request.getSession().getAttribute("user") != null)
            return "/blogAdmin";
        return "/admin/login";
    }

    @PostMapping("login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes redirectAttributes) {
        User user = userService.checkUser(username, password);
        if (user == null) {
            redirectAttributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin/login";
        }
        user.setPassword("");
        session.setAttribute("user", user);
        return "/admin/loginMessage";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin/login";
    }
}
