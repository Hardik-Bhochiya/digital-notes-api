package com.hardik.notesapi.controller;

import com.hardik.notesapi.entity.User;
import com.hardik.notesapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    // REGISTER
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return service.login(user.getUsername(), user.getPassword());
    }
}