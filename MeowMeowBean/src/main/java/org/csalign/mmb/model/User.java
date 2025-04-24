package org.csalign.mmb.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User> {

    public static int totalBeans = 0;

    private int beans;

    private int level;

    private String userId;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private List<Post> posts = new ArrayList<>();

    private List<Comment> comments = new ArrayList<>();

    public User() {}

    public User(String userId, String username, String password, int beans, int level) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.beans = beans;
        this.level = level;
        totalBeans += beans;
    }

   public String getUserId() {
        return userId;
   }

   public void setUserId(String userId) {
        this.userId = userId;
   }

   public String getUsername() {
        return username;
   }

   public void setUsername(String username) {
        this.username = username;
   }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void removePost(Post post) {
        posts.remove(post);
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

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
        totalBeans += beans;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void takeBeans(int beans) {
        this.beans += beans;
        totalBeans += beans;
        updateLevel();
    }

    public int castBeans(int rating) {
        if (Math.abs(rating) == 2 && beans >= 2) {
            beans -= 2;
            totalBeans -= 2;
        } else if (Math.abs(rating) == 1 && beans >= 1) {
            beans -= 1;
            totalBeans -= 1;
        } else {
            return 0;
        }
        updateLevel();
        return (level - 1) * rating;
    }

    private void updateLevel() {
        if ((double)beans / (double)totalBeans >= 0.2) {
            level = 5;
        } else if ((double)beans / (double)totalBeans >= 0.1) {
            level = 4;
        } else if ((double)beans / (double)totalBeans >= 0.05) {
            level = 3;
        } else if (beans >= 0) {
            level = 2;
        } else {
            level = 1;
        }
    }

    public int compareTo(User o) {
        return o.beans - this.beans;
    }

}
