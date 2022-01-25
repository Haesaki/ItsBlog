package org.sincq.itsblog.service.Impl;

import org.sincq.itsblog.dao.UserMapper;
import org.sincq.itsblog.entity.User;
import org.sincq.itsblog.service.UserService;
import org.sincq.itsblog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User checkUser(String userName, String userPasswd) {
        // 前端实现MD5加密
        // 在后端实现，如果攻击者在传输的时候截获就没有意义
        // 避免直接储存明文密码，数据库一泄漏就啥也没有
        User user = userMapper.getUserByUsername(userName);
        String encryptPasswd = MD5Util.encrypt(userPasswd);
        if (encryptPasswd.equals("") || !encryptPasswd.equals(user.getPassword()))
            return null;
        return user;
    }
}
