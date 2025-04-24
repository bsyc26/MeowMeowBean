package org.csalign.mmb.controller;

import org.csalign.mmb.model.Post;
import org.csalign.mmb.model.Rating;
import org.csalign.mmb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/api/post")
    public Iterable<Post> get() {
        Iterable<Post> posts = postService.get();
        if (posts == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Posts Found");
        }
        return posts;
    }

    @GetMapping("/api/post/{postId}")
    public Post get(@PathVariable String postId) {
        Post post = postService.get(postId);
        if (post == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post Not Found");
        }
        return post;
    }

    @DeleteMapping("/api/post/{postId}")
    public Post remove(@PathVariable String postId) {
        if (postService.get(postId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post Not Found");
        }
        return postService.remove(postId);
    }

    @PostMapping("/api/post")
    public Post add(@RequestBody @Validated Post post) {
        return postService.save(post);
    }

    @PostMapping("/api/post/{postId}/rating")
    public void rate(@PathVariable String postId, @RequestBody @Validated Rating rating) {
        if (postService.get(postId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post Not Found");
        }
        postService.rate(postId, rating);
    }

}
