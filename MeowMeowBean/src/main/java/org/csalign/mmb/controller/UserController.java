package org.csalign.mmb.controller;

import org.csalign.mmb.model.User;
import org.csalign.mmb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAll(Model model) {
        Iterable<User> users = userService.get();
        if (users == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Users Found");
        }
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/{userId}")
    public String get(Model mode, @PathVariable String userId) {
        User user = userService.get(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
        mode.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/users/new")
    public String add() {
        return "user-new";
    }

    @PostMapping("/users/new")
    public String add(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "User Created Successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "User Creation Failed: " + e.getMessage());
            return "redirect:/users/new";
        }
        return "redirect:/users/" + user.getUserId();
    }

}
