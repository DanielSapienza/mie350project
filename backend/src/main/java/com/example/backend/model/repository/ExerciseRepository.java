package com.example.backend.model.repository;

import com.example.backend.model.entity.Exercise;
import com.example.backend.model.entity.UserExerciseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, UserExerciseKey> {
}
