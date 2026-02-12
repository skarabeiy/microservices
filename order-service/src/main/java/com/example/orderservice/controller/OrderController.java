package com.example.orderservice.controller;

import com.example.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello from Order Service!";
    }

    @GetMapping("/test-feign")
    public String testFeign() {
        return orderService.testFeign();
    }

    @GetMapping("/call")
    public String call() {
        return orderService.unstableMethod();
    }
}