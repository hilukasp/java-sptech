package com.example.spring_JWToken.service;

import com.example.spring_JWToken.auth.JwtService;
import com.example.spring_JWToken.auth.SecurityConfig;
import com.example.spring_JWToken.auth.UserDetailsImpl;
import com.example.spring_JWToken.dto.CreateUserDto;
import com.example.spring_JWToken.dto.LoginUserDto;
import com.example.spring_JWToken.dto.RecoveryJwtTokenDto;
import com.example.spring_JWToken.model.Role;
import com.example.spring_JWToken.model.User;
import com.example.spring_JWToken.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtTokenService;

    @Autowired
    private SecurityConfig securityConfiguration;

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    // Métod responsável por autenticar um usuário e retornar um token JWT
    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }

    // Métod responsável por criar um usuário
    public void createUser(CreateUserDto createUserDto) {

        Role role = new Role();
        role.setName(createUserDto.getRole());

        // Cria um novo usuário com os dados fornecidos
        User newUser = new User();
        newUser.setEmail(createUserDto.getEmail());
        newUser.setPassword(
                securityConfiguration.passwordEncoder()
                        .encode(createUserDto.getPassword())
        );
        newUser.setRoles(List.of(role));

        // Salva o novo usuário no banco de dados
        repository.save(newUser);
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
