package com.example.spring_JWToken.repository;


import com.example.spring_JWToken.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
