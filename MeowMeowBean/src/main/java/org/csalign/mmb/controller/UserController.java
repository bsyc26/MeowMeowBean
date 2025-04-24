package org.csalign.mmb.controller;

import org.csalign.mmb.model.User;
import org.csalign.mmb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user")
    public Iterable<User> getAll() {
        Iterable<User> users = userService.get();
        if (users == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Users Found");
        }
        return users;
    }

    @GetMapping("/api/user/{userId}")
    public User get(@PathVariable String userId) {
        User user = userService.get(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
        return user;
    }

    @DeleteMapping("/api/user/{userId}")
    public User delete(@PathVariable String userId) {
        if (userService.get(userId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
        return userService.remove(userId);
    }

    @PostMapping("/api/user")
    public User add(@RequestBody @Validated User user) {
        return userService.save(user);
    }

}
