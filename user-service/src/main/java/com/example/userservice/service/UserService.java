package com.example.userservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class UserService {

    @Value("${word}")
    private String wordFromConfig;

    public String testConfig() {
        return wordFromConfig;
    }
}
