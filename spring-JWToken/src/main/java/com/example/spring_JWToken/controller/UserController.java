package com.example.spring_JWToken.controller;

import com.example.spring_JWToken.model.User;
import com.example.spring_JWToken.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> consultar() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(users);
    }
}
