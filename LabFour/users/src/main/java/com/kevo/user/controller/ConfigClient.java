package com.kevo.user.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClient {

    @Value("${user.role}")
    private String role;

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping(
            value = "/whoami/{username}",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoami(@PathVariable("username") String username) {
        System.out.println(role);
        return String.format("Hello! You're %s and you'll become a(n) %s...\n", username, role);
    }

    @RequestMapping("/greeting")
    public String greeting() {
        return String.format("Hello from %s!", eurekaClient.getApplication(appName).getName());
    }
}