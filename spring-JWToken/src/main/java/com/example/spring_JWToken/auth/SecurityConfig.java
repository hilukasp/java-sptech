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
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);
    //configura regras de segurança
    //permissoes

    private final JwtService jwtService;

    private final JwtAuthenticatorFilter jwtAuthenticatorFilter;

    public SecurityConfig(JwtService jwtService, JwtAuthenticatorFilter jwtAuthenticatorFilter) {
        this.jwtService = jwtService;
        this.jwtAuthenticatorFilter = jwtAuthenticatorFilter;
    }

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita restrição de X-Frame-Options para permitir o console H2 no browser.
                // Em produção, remova isso — o H2 console não deve ser exposto.
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))

                // Habilita CORS com a configuração definida em corsConfigurationSource()
                .cors(Customizer.withDefaults())

                // Desabilita CSRF (Cross-Site Request Forgery):
                // APIs REST stateless com JWT não precisam de proteção CSRF porque:
                // 1. Não usam cookies para autenticação (usam header Authorization)
                // 2. Browsers não enviam headers customizados em requisições cross-origin automaticamente
                // ATENÇÃO: se usar cookies para armazenar o token, habilite o CSRF novamente!
                .csrf(CsrfConfigurer<HttpSecurity>::disable)

                // Define quais URLs são públicas e quais exigem autenticação
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(URLS_PERMITIDAS).permitAll()  // rotas públicas
                        .anyRequest().authenticated()                  // todas as outras exigem token
                )

                // Configura o handler para erros de autenticação (token ausente/inválido → 401/403)
//                .exceptionHandling(handling -> handling
//                        .authenticationEntryPoint((AuthenticationEntryPoint) jwtAuthenticatorFilter))

                // Define política de sessão: STATELESS
                // O servidor NÃO cria nem armazena sessões HTTP.
                // Cada requisição é autenticada de forma independente pelo token JWT.
                // Isso torna a API escalável horizontalmente (sem estado compartilhado entre servidores).
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

        // Adiciona o filtro JWT ANTES do filtro padrão de autenticação por usuário/senha.
        // Isso garante que o token seja processado antes que o Spring Security tente
        // qualquer outro mecanismo de autenticação.
//        http.addFilterBefore(jwtAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);
        .httpBasic(Customizer.withDefaults());

        return http.build();
    }


}
