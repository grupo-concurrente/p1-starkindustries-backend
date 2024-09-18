package com.starksecurity.backend.controladores;

import com.starksecurity.backend.modelos.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {
    @GetMapping
    public List<Usuario> getUsuarios() {
        return List.of(
                new Usuario(1, "email1", "nombre1", "contrasena1", null));
    }
}
