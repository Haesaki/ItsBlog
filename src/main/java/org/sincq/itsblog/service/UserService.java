package org.sincq.itsblog.service;

import org.sincq.itsblog.entity.User;

public interface UserService {
    User checkUser(String userName, String userPasswd);
}
