package com.starksecurity.backend.controladores;

import com.starksecurity.backend.modelos.Rol;
import com.starksecurity.backend.modelos.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class ControladorUsuario {
    @GetMapping
    public List<Usuario> getUsuarios() {
        return List.of(
                new Usuario[]{
                        new Usuario(1, "email1", "user1", "contrasena1", Rol.USUARIO),
                        new Usuario(2, "email2", "admin1", "contrasena2", Rol.ADMINISTRADOR),
                }
        );
    }
}
