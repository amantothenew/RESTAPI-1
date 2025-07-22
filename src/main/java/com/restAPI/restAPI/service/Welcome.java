package com.restAPI.restAPI.service;

import org.springframework.stereotype.Component;

@Component
public class Welcome {
    public String display() {
        return "Welcome to spring boot";
    }
}
