package com.starksecurity.backend.configuraciones;

import com.starksecurity.backend.modelos.Rol;
import com.starksecurity.backend.modelos.Usuario;
import com.starksecurity.backend.repositorios.RepositorioUsuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class ConfiguracionUsuario {

    @Bean
    CommandLineRunner userRunner(RepositorioUsuario repositorioUsuario, PasswordEncoder passwordEncoder) {
        return args -> {
            Usuario defaultAdmin = new Usuario( "admin@starkindustries.com", "admin", passwordEncoder.encode("admin"), Rol.ADMINISTRADOR);
            Usuario defaultUser = new Usuario( "user@starkindustries.com", "user", passwordEncoder.encode("user"), Rol.USUARIO);
            repositorioUsuario.deleteAll();
            repositorioUsuario.saveAll(List.of(defaultAdmin, defaultUser));
        };
    }
}
