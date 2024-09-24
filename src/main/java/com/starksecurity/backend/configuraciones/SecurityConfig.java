package com.starksecurity.backend.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/publico/**").permitAll()  // Endpoints públicos
                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Solo accesible por ADMIN
                        .anyRequest().hasAnyRole("USER","ADMIN")    // Cualquier otra ruta requiere autenticación
                )
                .httpBasic(Customizer.withDefaults());  // Autenticación básica
        return http.build();
    }

    // Servicio de autenticación en memoria
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
            .username("user@starkindustries.com")
            .password(passwordEncoder.encode("user"))  // Cifrar contraseña del usuario
            .roles("USER")
            .build();

        UserDetails admin = User.builder()
            .username("admin@starkindustries.com")
            .password(passwordEncoder.encode("admin"))  // Cifrar contraseña del administrador
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    // Bean para el cifrado de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Usar BCrypt para cifrar las contraseñas
    }
}
