package com.example.spring_JWToken.service;

import com.example.spring_JWToken.model.User;
import com.example.spring_JWToken.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> listarTodos() {
        return repository.findAll();
    }

    public User criar(User user) {
        String senhaCriptografada = passwordEncoder.encode(user.getPassword());
        user.setPassword(senhaCriptografada);
        return repository.save(user);
    }

    public User findById(int id) {
        return repository.findById(id).orElse(null);
    }
}
