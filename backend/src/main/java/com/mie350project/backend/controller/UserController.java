package com.mie350project.backend.controller;

import com.mie350project.backend.model.entity.User;
import com.mie350project.backend.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UserController {
    @Autowired
    private UserRepository repository;

    public UserController(UserRepository repository){this.repository = repository;}

    @GetMapping("/users")
    List<User> retrieveAllUsers() {
        return repository.findAll();
    }


}
