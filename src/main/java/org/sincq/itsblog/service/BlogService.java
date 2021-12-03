package org.sincq.itsblog.service;

import com.github.pagehelper.Page;
import org.sincq.itsblog.entity.Blog;

public interface BlogService {
    Blog getBlog(Long id);
}
