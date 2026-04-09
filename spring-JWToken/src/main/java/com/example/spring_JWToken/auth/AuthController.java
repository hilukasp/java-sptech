package com.example.spring_JWToken.auth;

import com.example.spring_JWToken.dto.UserMapper;
import com.example.spring_JWToken.dto.UserRequestDto;
import com.example.spring_JWToken.dto.UserResponseDto;
import com.example.spring_JWToken.model.User;
import com.example.spring_JWToken.repository.UserRepository;
import com.example.spring_JWToken.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
//    private UserRepository userRepository;
    private UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager; //responsável por fazer o gerenciamento da autenticação


    public AuthController( PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {

        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@Valid @RequestBody UserRequestDto userRequestDto) {
        UsernamePasswordAuthenticationToken UserAndPass = new UsernamePasswordAuthenticationToken(userRequestDto.getEmail(),userRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(UserAndPass);


        return null;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<UserResponseDto> logar(@Valid @RequestBody UserRequestDto dto){
        //dto
        User user = UserMapper.toEntity(dto);

        //servico
        User salvo = userService.criar(user);

        //dto
        UserResponseDto responseDto=UserMapper.toResponseDto(salvo);

        //retorno
        return ResponseEntity.status(201).body(responseDto);
    }
}
