package org.csalign.mmb.controller;

import org.csalign.mmb.model.Comment;
import org.csalign.mmb.model.Rating;
import org.csalign.mmb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/api/post/{postId}/comment")
    public Iterable<Comment> get(@PathVariable String postId) {
        Iterable<Comment> comments = commentService.get(postId);
        if (comments == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Comments Found");
        }
        return comments;
    }

    @GetMapping("/api/post/{postId}/comment/{commentId}")
    public Comment get(@PathVariable String postId, @PathVariable String commentId) {
        Comment comment = commentService.get(postId, commentId);
        if (comment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment Not Found");
        }
        return comment;
    }

    @PostMapping("/api/post/{postId}/comment")
    public Comment add(@PathVariable String postId, @RequestBody Comment comment) {
        if (!postId.equals(comment.getPostId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment PostId Mismatch");
        }
        return commentService.save(comment);
    }

    @PostMapping("/api/post/{postId}/comment/{commentId}/rating")
    public void rate(@PathVariable String commentId, @Validated @RequestBody Rating rating) {
        if (commentService.get(commentId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment Not Found");
        }
        commentService.rate(commentId, rating);
    }

    @DeleteMapping("/api/post/{postId}/comment/{commentId}")
    public Comment remove(@PathVariable String postId, @PathVariable String commentId) {
        if (commentService.get(postId, commentId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment Not Found");
        }
        return commentService.remove(commentId);
    }

}
