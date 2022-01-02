package org.sincq.itsblog.service;

import com.github.pagehelper.Page;
import org.sincq.itsblog.entity.Blog;

import java.util.List;

public interface BlogService {
    Blog getBlog(Long id);
    int saveBlog(Blog blog);
    List<Blog> getAllBlog();
}
