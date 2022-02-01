package org.sincq.itsblog.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Blog {
    private Integer id;
    private String title;
    private String content;
    private String flag;
    private Integer views;
    private Integer commentCount;

    private boolean recommend;
    private boolean shareStatement;
    private boolean subscribeMe;
    private boolean commentable;
    private boolean publish;

    private Date createTime;
    private Date updateTime;

    private Integer typeId;
    private String typeName;
    private Integer userId;
    private String userName;
//    private List<Comment> comments = new ArrayList<>();
}
