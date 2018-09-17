package com.boot.example.springbootexample.web;

import com.boot.example.springbootexample.model.User;
import com.boot.example.springbootexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());

        return "users";
    }

    @GetMapping("/user/{userId}")
    public String updateUser(@PathVariable(name = "userId") String userId,
                             @RequestParam String action,
                             Model model) {
        if (!"update".equalsIgnoreCase(action)) {
            throw new RuntimeException("Resource not found!");
        }
        final User user = userService.findById(userId).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found!");
        }
        model.addAttribute("user", user);

        return "update-user";
    }

    @PostMapping("/user")
    public ModelAndView updateUser(User user, @RequestParam(name = "id") String id) {
        if (user == null) {
            throw new RuntimeException("User not found!");
        }
        User found = userService.findById(id).orElse(null);
        if (found == null) {
            throw new RuntimeException("User not found!");
        }
        found.setEmailAddress(user.getEmailAddress());
        found.setFirstName(user.getFirstName());
        found.setLastName(user.getLastName());
        userService.save(found);

        Map<String, Object> params = new HashMap<>();
        params.put("message", "User was successfully updated.");
        params.put("users", userService.findAll());

        return new ModelAndView("users", params);
    }

    @GetMapping("/deleteUser/{id}")
    public ModelAndView deleteUser(@PathVariable(name = "id") String id) {
        userService.delete(id);
        Map<String, Object> params = new HashMap<>();
        params.put("users", userService.findAll());
        return new ModelAndView("users", params);
    }
}
