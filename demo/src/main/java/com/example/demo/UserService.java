package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository1) {
        this.userRepository = userRepository1;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
