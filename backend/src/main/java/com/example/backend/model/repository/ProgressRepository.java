package com.example.backend.model.repository;

import com.example.backend.model.entity.Progress;
import com.example.backend.model.entity.UserProgressKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, UserProgressKey> {
}
