package com.example.spring_JWToken.controller;

import com.example.spring_JWToken.model.User;
import com.example.spring_JWToken.repository.UserRepository;
import com.example.spring_JWToken.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestParam("/users")
public class UserController {
    @GetMapping("/teste")
    public String hello(){
        return "hello";
    }

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> consultar() {
        List<User> users = userService.listarTodos();
        if(users.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(users);
    }
}
