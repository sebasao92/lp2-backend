package com.example.demo.user.infrastructure.controller;

import com.example.demo.user.application.UserEditionService;
import com.example.demo.user.domain.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserEditionController {

    private final UserEditionService userEditionService;

    @PutMapping("{id}")
    public User updateUser(@PathVariable("id") Long userId,
                           @RequestBody @Valid User user) {
        return userEditionService.edit(user.withId(userId));
    }
}
