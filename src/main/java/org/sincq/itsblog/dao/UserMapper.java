package org.sincq.itsblog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sincq.itsblog.entity.User;

import java.util.Date;

@Mapper
public interface UserMapper {
    void insertUser(User user);

    void deleteUserByUsername(String username);

    void deleteUserById(Integer id);

    void deleteUserByEmail(String email);

    void updateUserByUsername(String username, User user);

    void updateUserById(Integer id, User user);

    void updateUserByEmail(String email, User user);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    User getUserById(Integer id);
}
