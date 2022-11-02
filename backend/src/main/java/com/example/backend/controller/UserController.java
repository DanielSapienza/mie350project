package com.example.backend.controller;

import com.example.backend.model.entity.User;
import com.example.backend.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/users/{Client_ID}")
    void deleteUser(@PathVariable("Client_ID") int Client_ID) {repository.deleteById(Client_ID);
    }

}

