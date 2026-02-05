package com.example.userservice.messaging.producer;

import events.UserCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import topics.KafkaTopics;

@Service
public class UserEventProducer {

    private final KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;

    public UserEventProducer(KafkaTemplate<String, UserCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserCreated(UserCreatedEvent event) {
        kafkaTemplate.send(
                KafkaTopics.USER_CREATED,
                event.userId().toString(),
                event
        );
    }
}

