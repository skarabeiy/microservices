package com.example.reactiveservice.service;

import com.example.reactiveservice.model.User;
import com.example.reactiveservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Flux<User> getAllUsers() {
        return repository.findAll();
    }

    public Mono<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public Mono<User> createUser(User user) {
        return repository.save(user);
    }
}
