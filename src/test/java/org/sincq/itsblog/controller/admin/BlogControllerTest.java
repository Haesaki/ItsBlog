package org.sincq.itsblog.controller.admin;

import org.junit.jupiter.api.Test;
import org.sincq.itsblog.entity.Blog;
import org.sincq.itsblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Date;

//CREATE TABLE `t_blog` (
//        `id` int NOT NULL AUTO_INCREMENT,
//        `title` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
//        `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
//        `flag` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
//        `views` int NOT NULL,
//        `subscribeMe` tinyint(1) NOT NULL,
//        `shareStatement` tinyint(1) NOT NULL,
//        `commentable` tinyint(1) NOT NULL,
//        `publish` tinyint(1) NOT NULL,
//        `recommend` tinyint(1) NOT NULL,
//        `createTime` date NOT NULL,
//        `updateTime` date NOT NULL,
//        `typeId` int DEFAULT NULL,
//        `userId` int DEFAULT NULL,
//        `commentCount` int DEFAULT NULL,
//        `userName` int DEFAULT NULL,
//        `typeName` int DEFAULT NULL,
//        PRIMARY KEY (`id`)
//        ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin

@SpringBootTest
public class BlogControllerTest {
    @Autowired
    private BlogService blogService;

    @Test
    public void insertBlogTest() {
        Blog blog = new Blog();
        blog.setTitle("test");
        blog.setContent("test");
        blog.setFlag("test");
        blog.setViews(0);
        blog.setSubscribeMe(false);
        blog.setShareStatement(false);
        blog.setCommentable(true);
        blog.setPublish(true);
        blog.setRecommend(false);
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());

        blogService.saveBlog(blog);
    }
}
