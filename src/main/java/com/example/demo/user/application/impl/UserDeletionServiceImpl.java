package com.example.demo.user.application.impl;

import com.example.demo.user.application.UserDeletionService;
import com.example.demo.user.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDeletionServiceImpl implements UserDeletionService {

    private final UserRepository userRepository;

    @Override
    public void deleteById(Long id) {
        log.info("Deleting user");
        log.debug("User with ID={}", id);
        userRepository.deleteById(id);
    }
}
