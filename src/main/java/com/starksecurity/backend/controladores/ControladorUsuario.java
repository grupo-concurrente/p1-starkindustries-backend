package com.starksecurity.backend.controladores;

import com.starksecurity.backend.modelos.Usuario;
import com.starksecurity.backend.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/usuarios")
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getUsuarios() {
        return servicioUsuario.getUsuarios();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable("id") Long id) {
        return servicioUsuario.getUsuarioById(id);
    }

    // Agregar un nuevo usuario
    @PostMapping
    public void addUsuario(@RequestBody Usuario usuario) {
        servicioUsuario.addNewUsuario(usuario);
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable("id") Long id) {
        servicioUsuario.deleteUsuario(id);
    }

    // Actualizar un usuario por ID
    @PutMapping("/{id}")
    public void updateUsuario(
            @PathVariable("id") Long id,
            @RequestBody Usuario usuarioActualizado) {
        servicioUsuario.updateUsuario(id, usuarioActualizado);
    }
}
