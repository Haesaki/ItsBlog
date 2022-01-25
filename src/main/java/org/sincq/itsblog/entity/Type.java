package org.sincq.itsblog.entity;

import lombok.Data;

import java.util.List;

@Data
public class Type {
    private Integer id;
    private String name;

    private List<Blog> blogs;

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Type(){}
}
