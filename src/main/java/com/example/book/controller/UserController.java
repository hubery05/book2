package com.example.book.controller;

import com.example.book.entity.User;
import com.example.book.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final String USERNAME = "admin";
    private final String PASSWORD = "123456";
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        if(USERNAME.equals(user.getUsername()) && PASSWORD.equals(user.getPassword())) {
            user.setToken(JwtUtil.createToken());
            return user;
        }
        return null;
    }
}
