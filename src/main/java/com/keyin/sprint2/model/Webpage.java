package com.keyin.sprint2.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Webpage {
    @Value("${app.message}")
    private String message;

    public String get() {
        return message;
    }
}
