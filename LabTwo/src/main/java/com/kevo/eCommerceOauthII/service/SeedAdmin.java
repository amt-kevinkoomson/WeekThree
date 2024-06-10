package com.kevo.eCommerceOauthII.service;

import com.kevo.eCommerceOauthII.repository.UserRepository;
import com.kevo.eCommerceOauthII.entity.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeedAdmin {
    private final UserRepository repository;

    @Bean
    @Transactional
    public void seed() {
        User admin = User.builder()
                .email("admin@mail.com")
                .password(BCrypt.hashpw("password", BCrypt.gensalt()))
                .fullName("Admin")
                .build();

        System.out.println(repository.save(admin));
    }
}