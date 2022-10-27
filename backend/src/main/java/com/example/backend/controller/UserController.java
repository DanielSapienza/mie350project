package com.example.backend.controller;

import com.example.backend.model.entity.User;
import com.example.backend.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    public UserController(UserRepository repository){this.repository = repository;}

    @GetMapping("/users")
    List<User> retrieveAllUsers() {
        return repository.findAll();
    }


}

