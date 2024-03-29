package com.example.demo.user.application.impl;

import com.example.demo.user.application.UserViewService;
import com.example.demo.user.domain.User;
import com.example.demo.user.infrastructure.repository.UserEntity;
import com.example.demo.user.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserViewServiceImpl implements UserViewService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        log.info("Requesting all users");
        return userRepository.findAll().stream()
                .map(UserEntity::toDomain)
                .collect(Collectors.toList());
    }
}
