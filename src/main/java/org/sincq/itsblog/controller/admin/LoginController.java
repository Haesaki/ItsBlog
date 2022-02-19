package org.sincq.itsblog.controller.admin;

import org.sincq.itsblog.dao.UserChallengeMapper;
import org.sincq.itsblog.entity.User;
import org.sincq.itsblog.service.ChallengeService;
import org.sincq.itsblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    ChallengeService challengeService;

    // 拦截所有请求
    @GetMapping("admin")
    public String loginPage(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("user") != null) {
            return "admin/loginMessage";
        }
        // 如果多用户登录请求的话，还需要再加一个前端，算了吧，就只有我一个admin用户，直接只给admin提供
        // 如果后面要扩展到多用户的话，需要登录之前就进入一个界面要求用户输入用户名，这样可以查询相对应用户的challenge

        // 说明浏览器已经尝试过登录了,但是没有成功,就不刷新challenge
        Cookie[] browserCookies = request.getCookies();
        if (browserCookies != null) {
            for (Cookie cookie : browserCookies) {
                if ("challenge".equals(cookie.getName()))
                    return "admin/login";
            }
        }

        String challenge = challengeService.getChallengeByUsernameAFlushChallenge("admin");
        Cookie challengeCookie = new Cookie("challenge", challenge);
        challengeCookie.setMaxAge(10000);
        response.addCookie(challengeCookie);
        // return "/blogAdmin";
        return "admin/login";
    }

    @PostMapping("admin/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes redirectAttributes) {
        User user = userService.checkUser(username, password);
        if (user == null) {
            redirectAttributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:admin/login";
        }
        user.setPassword("");
        user.setEmail("");
        user.setAvatar("");
        user.setId(-1);

        session.setAttribute("user", user);
        return "admin/loginMessage";
    }

    @GetMapping("admin/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:admin/login";
    }
}
