package com.phu.crudapi.controllers;

import com.phu.crudapi.entity.User;
import com.phu.crudapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setId(0);
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable int id) {
        User user = userService.findUserById(id);
        if (user != null) {
            return user;
        } else {
            throw new RuntimeException("User not found : " + id);
        }
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        if (userService.findUserById(id) == null) {
            throw new RuntimeException("User not found : " + id);
        } else {
            userService.deleteUserById(id);
            return "Deleted user id - " + id;
        }
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
