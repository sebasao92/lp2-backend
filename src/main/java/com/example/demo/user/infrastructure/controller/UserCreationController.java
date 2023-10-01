package com.example.demo.user.infrastructure.controller;

import com.example.demo.user.application.UserCreationService;
import com.example.demo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserCreationController {

    private final UserCreationService userCreationService;

    @PostMapping
    @ResponseStatus(CREATED)
    public User createUser(@RequestBody @Valid User userToBeCreated) {
        return userCreationService.create(userToBeCreated);
    }
}
