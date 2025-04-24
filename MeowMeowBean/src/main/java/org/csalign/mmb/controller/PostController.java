package org.csalign.mmb.controller;

import org.csalign.mmb.model.Post;
import org.csalign.mmb.model.Rating;
import org.csalign.mmb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "post-detail";
    }

    @GetMapping("/posts/new")
    public String add() {
        return "post-new";
    }

    @PostMapping("/posts/new")
    public String add(Post post, RedirectAttributes redirectAttributes) {
        try {
            postService.save(post);
            redirectAttributes.addFlashAttribute("message", "Post Created Successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Post Creation Failed: " + e.getMessage());
            return "redirect:/posts/new";
        }
        return "redirect:/posts/" + post.getPostId();
    }

    @PostMapping("/posts/{postId}/rating")
    public String rate(Rating rating, RedirectAttributes redirectAttributes, @PathVariable String postId, Model model) {
        try {
            postService.rate(postId, rating);
            redirectAttributes.addFlashAttribute("message", "Post Rated Successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Post Rating Failed: " + e.getMessage());
        }
        model.addAttribute("postId", postId);
        return "redirect:/posts/" + postId;
    }

}
