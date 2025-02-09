package com.example.wattbook.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final JWTFilter jwtFilterChain;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req.requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/votos/**").permitAll()
                        .requestMatchers("/comentarios/**").permitAll()
                        .requestMatchers("/libros/**").permitAll()
                        .requestMatchers("/libros/crear").permitAll()
                        .requestMatchers("/usuario/**").permitAll()
                        .requestMatchers("/libros/MostrarLibros").permitAll()
                        .requestMatchers("/seguidores/anyadirSeguidor").permitAll()
                        .requestMatchers("/seguidores/eliminarSeguidor").permitAll()
                        .requestMatchers("/seguidores/listaSeguidores").permitAll()
                        .requestMatchers("/libros-favoritos/anyadirLibroFavorito").permitAll()
                        .requestMatchers("/libros-favoritos/listaLibros").permitAll()
                        .requestMatchers("/libros-favoritos/eliminarLibroFavorito").permitAll()
                        .requestMatchers("usuario/{id}/perfil").permitAll()
                        .requestMatchers("/publicacion/**").hasAuthority("PERFIL")
                        .requestMatchers("/aptitud/**").hasAuthority("ADMIN")

                        .anyRequest().authenticated())
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtFilterChain, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling((exception) -> exception.accessDeniedHandler(accessDeniedHandler()))
        ;
        return http.build();
    }
}
