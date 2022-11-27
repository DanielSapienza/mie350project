package com.example.backend.model.repository;

import com.example.backend.model.entity.Diet;
import com.example.backend.model.entity.UserMealKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends JpaRepository<Diet, UserMealKey> {

}
