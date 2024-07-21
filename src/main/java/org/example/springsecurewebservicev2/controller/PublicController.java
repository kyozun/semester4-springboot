package org.example.springsecurewebservicev2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublicController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public endpoint";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Admin endpoint";
    }

    @GetMapping("/home")
    public String homeEnpoint() {
        return "Home";
    }
}
