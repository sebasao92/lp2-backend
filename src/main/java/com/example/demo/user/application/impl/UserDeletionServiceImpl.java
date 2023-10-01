package com.example.demo.user.application.impl;

import com.example.demo.user.application.UserDeletionService;
import com.example.demo.user.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeletionServiceImpl implements UserDeletionService {

    private final UserRepository userRepository;

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
