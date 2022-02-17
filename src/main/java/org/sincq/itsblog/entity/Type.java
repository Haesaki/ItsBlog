package org.sincq.itsblog.entity;

import lombok.Data;

import java.util.List;

@Data
public class Type {
    private Integer id;
    private String name;

    private Integer blogNumber;

    private List<Blog> blogs;

    public Type(){}
}
