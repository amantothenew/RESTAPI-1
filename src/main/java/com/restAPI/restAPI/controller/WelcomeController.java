package com.restAPI.restAPI.controller;

import com.restAPI.restAPI.service.Welcome;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private Welcome welcome;

    WelcomeController(Welcome welcome) {
        this.welcome = welcome;
    }

    @GetMapping("/")
    public String WelcomeToSpringBoot() {
        return welcome.display();
    }
}
