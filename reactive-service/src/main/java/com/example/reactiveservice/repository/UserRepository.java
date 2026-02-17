package com.example.reactiveservice.repository;

import com.example.reactiveservice.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    // Кастомный метод - возвращает Flux (поток пользователей)
    Flux<User> findByName(String name);

    // Можно даже так (поддержка реактивных типов в параметрах - опционально)
    Mono<User> findByEmail(Mono<String> email);
}
