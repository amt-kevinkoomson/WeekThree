package com.kevo.eCommerceOauthII.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String home(){
        return "Welcome home";
    }

    @GetMapping("/public")
    public String homepage(){
        return "Hello World";
    }

    @GetMapping("/private")
    public String privateRoute(){
        return "Hello from private router";
    }

    @GetMapping("/user")
    public String user(Authentication auth) {
        if(auth instanceof OAuth2AuthenticationToken){
            OAuth2User oAuth2User = ((OAuth2AuthenticationToken) auth).getPrincipal();
            System.out.println(oAuth2User);
            String email = oAuth2User.getAttribute("email");
            String name = oAuth2User.getAttribute("name");
            return "Welcome " + name + " from " + email;
        }
        return "Welcome from private router";
    }
}
