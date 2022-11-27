package com.example.backend.model.repository;

import com.example.backend.model.entity.Sleep;
import com.example.backend.model.entity.UserSleepKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SleepRepository extends JpaRepository<Sleep, UserSleepKey> {
}
