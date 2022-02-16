package org.sincq.itsblog.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Comment {
    private Integer id;
    private String nickname;
    private String email;
    private String content;

    //头像
    private String avatar;
    private Date createTime;

    private Integer blogId;
    private Integer parentCommentId;
    private String parentNickname;

    //回复评论
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;
    private boolean adminComment;

    private Blog blog;

    // private Blog blog;

    public Comment() {
    }
}