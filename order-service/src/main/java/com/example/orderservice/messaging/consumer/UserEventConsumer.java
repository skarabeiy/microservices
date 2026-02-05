package com.example.orderservice.messaging.consumer;

import com.example.orderservice.service.OrderService;
import events.UserCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import topics.KafkaTopics;

@Service
public class UserEventConsumer {

    private final OrderService orderService;

    public UserEventConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @KafkaListener(topics = KafkaTopics.USER_CREATED)
    public void handle(UserCreatedEvent event) {
        orderService.handleUserCreated(event);
    }
}
