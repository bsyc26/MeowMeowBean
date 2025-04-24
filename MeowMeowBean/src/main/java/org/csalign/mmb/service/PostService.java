package org.csalign.mmb.service;

import org.csalign.mmb.model.Post;
import org.csalign.mmb.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService {

    private final UserService userService;

    @Autowired
    public PostService(UserService userService) {
        this.userService = userService;
    }

    private final Map<String, Post> postDB = new HashMap<>() {{
        put("5", new Post("5", "The Level 5's Post", "Example Content", "5"));
        put("2", new Post("2", "The Level 2's Post", "Example Content", "2"));
        put("1", new Post("1", "The Level 1's Post", "Example Content", "1"));
    }};

    public Iterable<Post> get() {
        List<Post> posts = new ArrayList<>(postDB.values());
        Collections.sort(posts);
        return posts;
    }

    public Post get(String postId) {
        return postDB.get(postId);
    }

    public Post save(Post post) {
        post.setPostId(UUID.randomUUID().toString());
        postDB.put(post.getPostId(), post);
        userService.get(post.getUserId()).addPost(post);
        return post;
    }

    public Post remove(String postId) {
        Post post = postDB.get(postId);
        userService.get(post.getUserId()).removePost(post);
        return postDB.remove(postId);
    }

    public void rate(String postId, Rating rating) {
        Post post = postDB.get(postId);
        int beans = userService.castBeans(rating.getUserId(), rating.getRating());
        post.takeBeans(beans);
        userService.takeBeans(post.getUserId(), beans);
    }

}
