package org.sincq.itsblog.service;

import org.sincq.itsblog.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Integer blogId);

    int saveComment(Comment comment);

    void deleteComment(Comment comment,Integer id);
}
