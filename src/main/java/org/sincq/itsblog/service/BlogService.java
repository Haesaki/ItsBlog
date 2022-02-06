package org.sincq.itsblog.service;

import com.github.pagehelper.Page;
import org.sincq.itsblog.entity.Blog;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlogService {
    Blog getBlog(Integer id);

    List<Blog> listBlog(SpringDataWebProperties.Pageable pageable, Blog blog);

    List<Blog> getSearchBlog(String blog);

    List<Blog> listAllBlog();

    int saveBlog(Blog blog);

    int updateBlog(Integer id, Blog blog);

    void deleteBlog(Integer id);
}
