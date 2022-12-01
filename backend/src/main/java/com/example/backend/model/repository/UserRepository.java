package com.example.backend.model.repository;

import com.example.backend.model.entity.Diet;
import com.example.backend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(value = "SELECT clientId, firstName, lastName, age, height, weight, password FROM UserProfile WHERE clientId = :clientId", nativeQuery = true)
//    User findSpecificUser(@Param("clientId") long clientId);

}
