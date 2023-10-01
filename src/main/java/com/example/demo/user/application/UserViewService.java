package com.example.demo.user.application;

import com.example.demo.user.domain.User;

import java.util.List;

public interface UserViewService {

    List<User> findAll();
}
