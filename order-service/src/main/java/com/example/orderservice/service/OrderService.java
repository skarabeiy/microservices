package com.example.orderservice.service;

import com.example.orderservice.client.UserClient;
import events.UserCreatedEvent;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderService {

    private final UserClient userClient;
    private final Random random = new Random();

    public OrderService(UserClient userClient) {
        this.userClient = userClient;
    }

    public String testFeign() {
        return "Hello from Order Service!\n" + userClient.testUserService();
    }

    public void handleUserCreated(UserCreatedEvent event) {
        System.out.println(event.userId() + " " + event.email());
    }

    @CircuitBreaker(name = "randomService", fallbackMethod = "fallback")
    public String unstableMethod() {

        int chance = random.nextInt(100);

        if (chance < 80) {  // 80% вероятность падения
            throw new RuntimeException("Случайная ошибка!");
        }

        return "Успешный ответ 🎉";
    }

    // в случае ошибки или если CircuitBreaker = open
    public String fallback(Throwable t) {
        return "Fallback: сервис временно недоступен";
    }
}
