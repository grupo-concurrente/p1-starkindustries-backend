package com.starksecurity.backend.controladores;

import com.starksecurity.backend.dto.LoginRequest;
import com.starksecurity.backend.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("publico/login")
public class LoginController {

    @Autowired
    private ServicioUsuario usuarioService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean esValido = usuarioService.verificarUsuario(loginRequest.getEmail(), loginRequest.getPassword());

        if (esValido) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }
    }
}


