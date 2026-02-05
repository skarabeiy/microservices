package com.example.userservice.service;

import com.example.userservice.messaging.producer.UserEventProducer;
import events.UserCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class UserService {

    @Value("${word}")
    private String wordFromConfig;

    private final UserEventProducer userEventProducer;

    public UserService(UserEventProducer userEventProducer) {
        this.userEventProducer = userEventProducer;
    }

    public String testConfig() {
        return wordFromConfig;
    }

    public void createUser() {
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent(1L, "example@mail.com");
        userEventProducer.sendUserCreated(userCreatedEvent);
    }
}
