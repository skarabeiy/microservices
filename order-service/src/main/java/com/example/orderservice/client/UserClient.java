package com.example.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service",
        path = "/users")
public interface UserClient {

    @GetMapping("/test")
    String testUserService();
}
