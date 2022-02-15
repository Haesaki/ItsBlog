package org.sincq.itsblog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.sincq.itsblog.entity.Blog;
import org.sincq.itsblog.entity.Type;
import org.sincq.itsblog.entity.User;

import java.util.Date;
import java.util.List;

@Mapper
public interface BlogMapper {

    int updateCommentCountById(Integer id);

    List<Blog> listAllBlog();

    List<Blog> getSearchBlog(String blog);
    // numPerPage   每一页多少博客
    // PageNum      第几页
//    List<Blog> listBlogInPage(@Param("numPerPage") int numPerPage, @Param("PageNum") int PageNum);

    List<Blog> listAllRecommendBlog();

    int saveBlog(Blog blog);

    void deleteBlog(Integer id);

    void updateTitle(@Param("id") Integer id, @Param("title") String title);

    void updateContent(Integer id, String content);

    void updateFlag(Integer id, String flag);

    void updateViews(Integer id, Integer views);

    void updateCommentCount(Integer id, Integer commentCount);

    void updateSubscribeMe(Integer id, Boolean subscribeMe);

    void updateShareStatement(Integer id, Boolean shareStatement);

    void updateBlogById(Integer id, Blog blog);

//    void updateCommentable(Integer id, Boolean commentable);
//
//    void updatePublish(Integer id, Boolean publish);
//
//    void updateRecommend(Integer id, Boolean recommend);
//
//    void updateCreateTime(Integer id, Date createTime);
//
//    void updateUpdateTime(Integer id, Date updateTime);
//
//    void updateTypeId(Integer id, Integer typeId);
//
//    void updateUserId(Integer id, Integer userId);
//
    Blog getBlogById(Integer id);
}
