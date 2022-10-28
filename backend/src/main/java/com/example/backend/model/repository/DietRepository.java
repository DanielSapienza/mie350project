package com.example.backend.model.repository;

import com.example.backend.model.entity.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepository extends JpaRepository<Diet, String> {

}
