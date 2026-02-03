package com.example.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/test")
    public Map<String, String> test() {
        return Collections.singletonMap("message", "Hello from User Service!");
    }

    @GetMapping("/info")
    public Map<String, String> getUserInfo() {
        return Map.of(
                "service", "user-service",
                "status", "running",
                "endpoint", "/users/info"
        );
    }
}