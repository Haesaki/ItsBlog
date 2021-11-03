package org.sincq.itsblog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Blog {
    private Long id;
    private String title;
    private String content;
    private String flag;
    private Long views;
    private boolean subscribeMe;
    private boolean shareStatement;
    private boolean commentable;
    private boolean publish;
    private boolean recommend;
    private Date createTime;
    private Date updateTime;

    private Long typeId;
    private Type type;
    private Long userId;
    private User user;
    private List<Comment> comments = new ArrayList<>();

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public boolean issubscribeMe() {
        return subscribeMe;
    }

    public void setsubscribeMe(boolean subscribeMe) {
        this.subscribeMe = subscribeMe;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public boolean isCommentable() {
        return commentable;
    }

    public void setCommentable(boolean commentable) {
        this.commentable = commentable;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", subscribeMe=" + subscribeMe +
                ", shareStatement=" + shareStatement +
                ", commentable=" + commentable +
                ", publish=" + publish +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", typeId=" + typeId +
                ", type=" + type +
                ", userId=" + userId +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }

    public boolean isSubscribeMe() {
        return subscribeMe;
    }

    public void setSubscribeMe(boolean subscribeMe) {
        this.subscribeMe = subscribeMe;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
