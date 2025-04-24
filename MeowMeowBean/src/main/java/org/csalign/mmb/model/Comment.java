package org.csalign.mmb.model;

import jakarta.validation.constraints.NotEmpty;

public class Comment implements Comparable<Comment> {

    private String commentId;

    @NotEmpty
    private String postId;

    @NotEmpty
    private String userId;

    @NotEmpty
    private String content;

    private int beans;

    public Comment() {
    }

    public Comment(String postId, String userId, String content) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public void takeBeans(int beans) {
        this.beans += beans;
    }

    @Override
    public int compareTo(Comment o) {
        return o.beans - this.beans;
    }

}