package org.sincq.itsblog.service;

import com.github.pagehelper.Page;
import org.sincq.itsblog.entity.Blog;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

public interface BlogService {
    Blog getBlog(Long id);

    Page<Blog> listBlog(SpringDataWebProperties.Pageable pageable, Blog blog);

    Page<Blog> listAllBlog();

    int saveBlog(Blog blog);

    int updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);
}
