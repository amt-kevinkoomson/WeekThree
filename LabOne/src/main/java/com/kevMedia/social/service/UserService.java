package com.kevMedia.social.service;

import com.kevMedia.social.entity.User;
import com.kevMedia.social.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
