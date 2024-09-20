package com.starksecurity.backend.controladores;

import com.starksecurity.backend.modelos.Usuario;
import com.starksecurity.backend.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return servicioUsuario.getUsuarios();
    }

    @PostMapping
    public void addUsuario(@RequestBody Usuario usuario) {
        servicioUsuario.addNewUsuario(usuario);
    }
}
