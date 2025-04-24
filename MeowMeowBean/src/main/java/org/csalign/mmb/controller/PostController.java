package org.csalign.mmb.controller;

import org.csalign.mmb.model.Post;
import org.csalign.mmb.model.Rating;
import org.csalign.mmb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String get(Model model) {
        List<Post> posts = postService.get();
        if (posts == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Posts Found");
        }
        model.addAttribute("posts", posts);
        model.addAttribute("name", "MeowMeowBean");
        return "posts";
    }

    @GetMapping("/posts/{postId}")
    public String get(Model model, @PathVariable String postId) {
        Post post = postService.get(postId);
        if (post == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post Not Found");
        }
        model.addAttribute("post", post);
        model.addAttribute("author", post.getUserId());
        return "post";
    }

    @DeleteMapping("/posts/{postId}")
    public Post remove(@PathVariable String postId) {
        if (postService.get(postId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post Not Found");
        }
        return postService.remove(postId);
    }

    @GetMapping("/posts/new")
    public String add(Model model) {
        model.addAttribute("post", new Post());
        return "new-post";
    }

    @PostMapping("/posts/new")
    public Post add(@RequestBody @Validated Post post) {
        return postService.save(post);
    }

    @PostMapping("/posts/{postId}/rating")
    public void rate(@PathVariable String postId, @RequestBody @Validated Rating rating) {
        if (postService.get(postId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post Not Found");
        }
        postService.rate(postId, rating);
    }

}
