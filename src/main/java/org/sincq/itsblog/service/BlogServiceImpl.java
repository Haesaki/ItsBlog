package org.sincq.itsblog.service;

import org.sincq.itsblog.dao.BlogMapper;
import org.sincq.itsblog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Blog getBlog(Long id) {
        return blogMapper.getBlogById(id);
    }

    public int saveBlog(Blog blog){
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogMapper.saveBlog(blog);
    }

    @Override
    public List<Blog> getAllBlog() {
        return getAllBlog();
    }
}
