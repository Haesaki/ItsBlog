package org.sincq.itsblog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private Integer type;
    private Date createTime;
    private Date updateTime;

    public User() {
    }
}
