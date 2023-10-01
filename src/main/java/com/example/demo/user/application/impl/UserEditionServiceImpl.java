package com.example.demo.user.application.impl;

import com.example.demo.exception.NotFoundException;
import com.example.demo.user.application.UserEditionService;
import com.example.demo.user.domain.User;
import com.example.demo.user.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserEditionServiceImpl implements UserEditionService {

    private static final String USER_NOT_FOUND_ERROR_MESSAGE = "User with ID %d was not found";

    private final UserRepository userRepository;

    @Override
    public User edit(User user) {
        log.info("Editing user");
        log.debug("User to be edited: {}", user);
        validateIfUserExists(user);
        return userRepository.save(user.toEntity())
                .toDomain();
    }

    private void validateIfUserExists(User user) {
        Objects.requireNonNull(user, "User cannot be null");
        Optional.of(user)
                .map(User::getId)
                .filter(userRepository::existsById)
                .orElseThrow(() -> new NotFoundException(String.format(USER_NOT_FOUND_ERROR_MESSAGE, user.getId())));
    }
}
