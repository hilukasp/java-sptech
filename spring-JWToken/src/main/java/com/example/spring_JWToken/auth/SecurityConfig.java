package com.example.spring_JWToken.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//por padrão as portas das rotas são bloquados apartir do momento que vc implementa as portas
@Configuration //essa classe contem um bin de configuração
@EnableWebSecurity
public class SecurityConfig {
    private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);
    //configura regras de segurança
    //permissoes

//    private final JwtService jwtService;
//
//    private final JwtAuthenticatorFilter jwtAuthenticatorFilter;
//
//    public SecurityConfig(JwtService jwtService, JwtAuthenticatorFilter jwtAuthenticatorFilter) {
//        this.jwtService = jwtService;
//        this.jwtAuthenticatorFilter = jwtAuthenticatorFilter;
//    }

    private static final String[] URLS_PERMITIDAS = {
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/api/public/**",
            "/api/public/authenticate",
            "/webjars/**",
            "/v3/api-docs/**",
            "/actuator/*",
            "/usuarios/login/**",
            "/usuarios/logout/**",
            "/h2-console/**",
            "/h2-console/*/**",
            "/error/**"
    };

//onde define as regras de acesso
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //  Permite abrir o H2 Console no navegador
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))

                // Habilita CORS com a configuração definida em corsConfigurationSource()
                .cors(Customizer.withDefaults())

                // Desativa proteção CSRF, necessário para JWT
                .csrf(CsrfConfigurer<HttpSecurity>::disable)

                // Define quais URLs são públicas e quais exigem autenticação
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(URLS_PERMITIDAS).permitAll()  // rotas desprotegidas
                        .anyRequest().authenticated()                  // todas as outras exigem token
                )

                // Configura o handler para erros de autenticação (token ausente/inválido → 401/403)
//                .exceptionHandling(handling -> handling
//                        .authenticationEntryPoint((AuthenticationEntryPoint) jwtAuthenticatorFilter))

                // Define política de sessão: STATELESS
                // O servidor NÃO cria nem armazena sessões HTTP
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))


//        http.addFilterBefore(jwtAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);
        .httpBasic(Customizer.withDefaults()); //essa função é uma autenticação que é feita para teste, sem a integração do jwt
        //comente a linha depois dos testes

        return http.build();


    }

    //responsáve por criptografa a senha
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
