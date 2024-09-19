package com.starksecurity.backend.servicios;

import com.starksecurity.backend.modelos.Rol;
import com.starksecurity.backend.modelos.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuario {
    public List<Usuario> getUsuarios() {
        return List.of(
                new Usuario[]{
                        new Usuario(1, "email1", "user1", "contrasena1", Rol.USUARIO),
                        new Usuario(2, "email2", "admin1", "contrasena2", Rol.ADMINISTRADOR),
                }
        );
    }
}
