package com.example.spring_JWToken.service;

import com.example.spring_JWToken.model.User;
import com.example.spring_JWToken.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(int id) {
        return repository.findById(id).orElse(null);
    }
}
