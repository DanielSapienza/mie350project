package com.example.backend.controller;

import com.example.backend.model.repository.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class DietController {
    @Autowired
    private DietRepository repository;

    public DietController(DietRepository repository){
        this.repository = repository;
    }

}