package com.example.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/test")
    public Map<String, String> test() {
        return Map.of("message", "Hello from Order Service!");
    }

    @GetMapping("/info")
    public Map<String, String> getOrderInfo() {
        return Map.of(
                "service", "order-service",
                "status", "running",
                "endpoint", "/orders/info"
        );
    }
}