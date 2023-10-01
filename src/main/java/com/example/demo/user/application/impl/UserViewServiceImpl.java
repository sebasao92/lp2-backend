package com.example.demo.user.application.impl;

import com.example.demo.user.application.UserViewService;
import com.example.demo.user.domain.User;
import com.example.demo.user.infrastructure.repository.UserEntity;
import com.example.demo.user.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserViewServiceImpl implements UserViewService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(UserEntity::toDomain)
                .toList();
    }
}
