package com.kaushik.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthCheck {
    @GetMapping("/health")
    public Map<String, String> healthCheck() {
        return Map.of("status", "UP");
    }
}
