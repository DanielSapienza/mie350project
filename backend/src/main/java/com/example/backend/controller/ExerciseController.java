package com.example.backend.controller;

import com.example.backend.model.entity.Exercise;
import com.example.backend.model.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ExerciseController {
    @Autowired
    private ExerciseRepository repository;

    public ExerciseController(ExerciseRepository repository){this.repository = repository;}

    @GetMapping("/exercises")
    List<Exercise> retrieveAllExercises() {
        return repository.findAll();
    }


}

