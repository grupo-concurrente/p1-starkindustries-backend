package com.starksecurity.backend.configuraciones;

import com.starksecurity.backend.modelos.Rol;
import com.starksecurity.backend.modelos.Usuario;
import com.starksecurity.backend.repositorios.RepositorioUsuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConfiguracionUsuario {

    @Bean
    CommandLineRunner commandLineRunner(RepositorioUsuario repositorioUsuario) {
        return args -> {
            Usuario defaultAdmin = new Usuario( "admin@starkindustries.com", "admin1", "admin", Rol.ADMINISTRADOR);
            Usuario defaultUser = new Usuario( "default@starkindustries.com", "user1", "user", Rol.USUARIO);
            repositorioUsuario.deleteAll();
            repositorioUsuario.saveAll(List.of(defaultAdmin, defaultUser));
        };
    }
}
