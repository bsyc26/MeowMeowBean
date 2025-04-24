package org.csalign.mmb.service;

import org.csalign.mmb.model.Comment;
import org.csalign.mmb.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CommentService {

    private final UserService userService;

    private final PostService postService;

    private final Map<String, Comment> commentDB = new HashMap<>();

    private final Map<String, List<Comment>> postCommentDB = new HashMap<>();

    @Autowired
    public CommentService(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    public Iterable<Comment> get(String postId) {
        List<Comment> comments = postCommentDB.get(postId);
        if (comments != null) {
            Collections.sort(comments);
        }
        return comments;
    }

    public Comment get(String postId, String commentId) {
        return commentDB.get(commentId);
    }

    public Comment save(Comment comment) {
        String commentId = UUID.randomUUID().toString();
        comment.setCommentId(commentId);
        commentDB.put(commentId, comment);
        if (postCommentDB.get(comment.getPostId()) == null) {
            postCommentDB.put(comment.getPostId(), new ArrayList<>());
        }
        postCommentDB.get(comment.getPostId()).add(comment);
        userService.get(comment.getUserId()).addComment(comment);
        postService.get(comment.getPostId()).addComment(comment);
        return comment;
    }

    public Comment remove(String commentId) {
        Comment comment = commentDB.get(commentId);
        commentDB.remove(commentId);
        postCommentDB.get(comment.getPostId()).remove(comment);
        userService.get(comment.getUserId()).removeComment(comment);
        postService.get(comment.getPostId()).removeComment(comment);
        return comment;
    }

    public void rate(String commentId, Rating rating) {
        Comment comment = commentDB.get(commentId);
        comment.takeBeans(rating.getRating());
        userService.castBeans(rating.getUserId(), rating.getRating());
        userService.takeBeans(comment.getUserId(), rating.getRating());
    }

}
