package org.sincq.itsblog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sincq.itsblog.entity.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {
    //根据创建时间倒序来排
    List<Comment> findByBlogIdParentIdNull(@Param("blogId") Integer blogId, @Param("blogParentId") Integer blogParentId);

    //查询一级回复
    List<Comment> findByBlogIdParentIdNotNull(@Param("blogId") Integer blogId, @Param("id") Integer id);

    //查询二级回复
    List<Comment> findByBlogIdAndReplayId(@Param("blogId") Integer blogId,@Param("childId") Integer childId);

    //查询父级对象
//    Comment findByParentCommentId(Integer parentCommentId);

    //添加一个评论
    int saveComment(Comment comment);

    //删除评论
    void deleteComment(Integer id);
}
