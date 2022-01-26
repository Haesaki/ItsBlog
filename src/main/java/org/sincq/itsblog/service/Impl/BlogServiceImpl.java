package org.sincq.itsblog.service.Impl;

import com.github.pagehelper.Page;
import org.sincq.itsblog.dao.BlogMapper;
import org.sincq.itsblog.entity.Blog;
import org.sincq.itsblog.exception.NotFoundException;
import org.sincq.itsblog.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Controller;

@Controller
public class BlogServiceImpl implements BlogService {
    private BlogMapper blogMapper;

    @Autowired
    public void setBlogMapper(BlogMapper blogMapper){
        this.blogMapper = blogMapper;
        assert this.blogMapper != null;
    }

    @Override
    public Blog getBlog(Long id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    public Page<Blog> listBlog(SpringDataWebProperties.Pageable pageable, Blog blog) {
        return null;
    }

    @Override
    public Page<Blog> listAllBlog() {
        return null;
    }

    @Override
    public int saveBlog(Blog blog) {
        return blogMapper.saveBlog(blog);
    }

    @Override
    public int updateBlog(Long id, Blog blog) {
        Blog b = blogMapper.getBlogById(id);
        if(b == null){
            throw  new NotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(b, blog);
        return blogMapper.saveBlog(b);
    }

    @Override
    public void deleteBlog(Long id) {
        blogMapper.deleteBlog(id);
    }
}
