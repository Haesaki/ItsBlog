package org.sincq.itsblog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sincq.itsblog.entity.Blog;
import org.sincq.itsblog.entity.Type;
import org.sincq.itsblog.entity.User;

import java.util.Date;
import java.util.List;

@Mapper
public interface BlogMapper {
    List<Blog> listAllBlog();

    // numPerPage   每一页多少博客
    // PageNum      第几页
    List<Blog> listBlogInPage(@Param("numPerPage") int numPerPage, @Param("PageNum") int PageNum);

    List<Blog> listAllRecommendBlog();

    int saveBlog(Blog blog);

    void deleteBlog(Long id);

    void updateTitle(@Param("id") Long id, @Param("title") String title);

    void updateContent(Long id, String content);

    void updateFlag(Long id, String flag);

    void updateViews(Long id, Long views);

    void updateSubscribeMe(Long id, Boolean subscribeMe);

    void updateShareStatement(Long id, Boolean shareStatement);

//    void updateCommentable(Long id, Boolean commentable);
//
//    void updatePublish(Long id, Boolean publish);
//
//    void updateRecommend(Long id, Boolean recommend);
//
//    void updateCreateTime(Long id, Date createTime);
//
//    void updateUpdateTime(Long id, Date updateTime);
//
//    void updateTypeId(Long id, Long typeId);
//
//    void updateUserId(Long id, Long userId);
//
//    Blog getBlogById(Long id);
}
