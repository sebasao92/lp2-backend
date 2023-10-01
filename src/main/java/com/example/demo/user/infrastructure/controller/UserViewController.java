package com.example.demo.user.infrastructure.controller;

import com.example.demo.user.application.UserViewService;
import com.example.demo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserViewController {

    private final UserViewService userViewService;

    @GetMapping
    @ResponseStatus(OK)
    public List<User> getUsers() {
        return userViewService.findAll();
    }
}
