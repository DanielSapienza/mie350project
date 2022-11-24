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
    void deleteUser(@PathVariable("Client_ID") Long Client_ID) {repository.deleteById(Client_ID);
    }

    @PutMapping("/users/{Client_ID}")
    User updateUser(@RequestBody User newUser, @PathVariable("Client_ID") Long Client_Id) {
        return repository.findById(Client_Id)
                .map(user -> {
                    user.setFirst_Name(newUser.getFirst_Name());
                    user.setLast_Name(newUser.getLast_Name());
                    user.setAge(newUser.getAge());
                    user.setHeight(newUser.getHeight());
                    user.setWeight(newUser.getWeight());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setClient_Id(Client_Id);
                    return repository.save(newUser);
                });
    }
}

