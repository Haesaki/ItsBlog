package org.sincq.itsblog;

import org.junit.jupiter.api.Test;
import org.sincq.itsblog.dao.TypeMapper;
import org.sincq.itsblog.dao.UserMapper;
import org.sincq.itsblog.entity.Type;
import org.sincq.itsblog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


@SpringBootTest
public class mybatisTest {

//    @Autowired
//    private TypeMapper typeMapper;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    void typeTest(){
//        Type a =new Type();
//        a.setId(1);
//        a.setName("我爱学习");
//        typeMapper.insertType(a);
//
//        System.out.println(typeMapper.getAllType());
//
////        typeMapper.insertType(a);
////
////        System.out.println(typeMapper.getTypeById(1));
////
////        typeMapper.deleteTypeById(1);
////
////        System.out.println(typeMapper.getTypeById(1));
////
////        typeMapper.insertType(a);
////
////        System.out.println(typeMapper.getTypeById(1));
////
////        typeMapper.deleteTypeByName("我爱学习");
////
////        System.out.println(typeMapper.getTypeById(1));
////
////        typeMapper.insertType(a);
////
////        System.out.println(typeMapper.getAllType());
////
////        typeMapper.deleteTypeByName("我爱学习");
//    }
//
//    @Test
//    void userTest(){
//        User user = new User();
//        Date date = new Date();
//        user.setAvatar("");
//        user.setCreateTime(date);
//        user.setEmail("84838062+Haesaki@users.noreply.github.com");
//        user.setUsername("admin");
//        user.setNickname("Haesaki");
//        user.setId(1);
//        user.setPassword("admin");
//        user.setType(1);
//        user.setUpdateTime(date);
//
//        userMapper.insertUser(user);
//
////        System.out.println(userMapper.getUserById(7));
////
////        System.out.println(userMapper.getUserByUsername("admin"));
////
////        System.out.println(userMapper.getUserByEmail("laohapi@gmail.com"));
////
////        userMapper.deleteUserById(7);
////        System.out.println(userMapper.getUserById(7));
////
////        userMapper.insertUser(user);
////        userMapper.deleteUserByEmail("laohapi@gmail.com");
////
////        userMapper.insertUser(user);
////        userMapper.deleteUserByUsername("admin");
//    }
}
