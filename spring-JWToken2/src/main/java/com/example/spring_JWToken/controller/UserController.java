package com.example.spring_JWToken.controller;

import com.example.spring_JWToken.dto.*;
import com.example.spring_JWToken.model.User;
import com.example.spring_JWToken.repository.UserRepository;
import com.example.spring_JWToken.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDto> authenticateUser(@RequestBody LoginUserDto loginUserDto) {
        RecoveryJwtTokenDto token = userService.authenticateUser(loginUserDto);
        return ResponseEntity.ok(token);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserDto createUserDto) {
        User user=userService.createUser(createUserDto);
        UserResponseDto responseDto=UserMapper.toResponseDto(user);
        return ResponseEntity.status(201).body(responseDto);
    }

    @GetMapping("/none")
    public ResponseEntity<String> getAuthenticationNoneTest() {
        return new ResponseEntity<>("Sem autenticação", HttpStatus.OK);
    }


    @GetMapping("/test")
    public ResponseEntity<String> getAuthenticationTest() {
        return new ResponseEntity<>("Autenticado com sucesso", HttpStatus.OK);
    }

    @GetMapping("/test/customer")
    public ResponseEntity<String> getCustomerAuthenticationTest() {
        return new ResponseEntity<>("Cliente autenticado com sucesso", HttpStatus.OK);
    }

    @GetMapping("/test/administrator")
    public ResponseEntity<String> getAdminAuthenticationTest() {
        return new ResponseEntity<>("Administrador autenticado com sucesso", HttpStatus.OK);
    }

}