package com.starksecurity.backend.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.starksecurity.backend.repositorios.RepositorioUsuario;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/health")
public class ControladorHealthCheck {

    private final RepositorioUsuario repositorioUsuario;

    @Autowired
    public ControladorHealthCheck(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    @GetMapping
    public ResponseEntity<String> checkHealth() {
        try {
            // Intentar hacer una operación en la base de datos
            repositorioUsuario.count();
            return ResponseEntity.ok("UP");
        } catch (Exception e) {
            return ResponseEntity.status(503).body("DOWN");
        }
    }
}
