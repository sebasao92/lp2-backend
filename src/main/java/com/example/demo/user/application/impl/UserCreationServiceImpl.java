package com.example.demo.user.application.impl;

import com.example.demo.user.application.UserCreationService;
import com.example.demo.user.domain.User;
import com.example.demo.user.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserCreationServiceImpl implements UserCreationService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        log.info("Creating user");
        log.debug("User to be created: {}", user);
        return userRepository.save(user.toEntity())
                .toDomain();
    }
}
