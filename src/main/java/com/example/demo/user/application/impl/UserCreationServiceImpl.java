package com.example.demo.user.application.impl;

import com.example.demo.user.application.UserCreationService;
import com.example.demo.user.domain.User;
import com.example.demo.user.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreationServiceImpl implements UserCreationService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user.toEntity())
                .toDomain();
    }
}
