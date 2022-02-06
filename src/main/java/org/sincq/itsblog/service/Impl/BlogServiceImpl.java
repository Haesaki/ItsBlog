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

import java.util.List;

@Controller
public class BlogServiceImpl implements BlogService {
    private BlogMapper blogMapper;

    @Autowired
    public void setBlogMapper(BlogMapper blogMapper){
        this.blogMapper = blogMapper;
        assert this.blogMapper != null;
    }

    @Override
    public Blog getBlog(Integer id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    public List<Blog> listBlog(SpringDataWebProperties.Pageable pageable, Blog blog) {
        return null;
    }

    @Override
    public List<Blog> getSearchBlog(String blog){
        return null;
    }

    @Override
    public List<Blog> listAllBlog() {
        return blogMapper.listAllBlog();
    }

    @Override
    public int saveBlog(Blog blog) {
        return blogMapper.saveBlog(blog);
    }

    @Override
    public int updateBlog(Integer id, Blog blog) {
        Blog b = blogMapper.getBlogById(id);
        if(b == null){
            throw  new NotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(b, blog);
        return blogMapper.saveBlog(b);
    }

    @Override
    public void deleteBlog(Integer id) {
        blogMapper.deleteBlog(id);
    }
}
