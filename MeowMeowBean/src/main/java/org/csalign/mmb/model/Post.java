package org.csalign.mmb.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public class Post implements Comparable<Post> {

    private String postId;

    private int beans;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    private String userId;

    private List<Comment> comments = new ArrayList<>();

    public Post() {}

    public Post(String postId, String title, String content, String userId) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    public void takeBeans(int beans) {
        this.beans += beans;
    }

    public int compareTo(Post o) {
        return o.beans - this.beans;
    }

}
