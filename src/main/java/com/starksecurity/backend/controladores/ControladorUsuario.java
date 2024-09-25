package com.starksecurity.backend.controladores;

import com.starksecurity.backend.modelos.Usuario;
import com.starksecurity.backend.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("publico/api/v1/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ControladorUsuario(ServicioUsuario servicioUsuario, PasswordEncoder passwordEncoder) {
        this.servicioUsuario = servicioUsuario;
        this.passwordEncoder = passwordEncoder;
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
        servicioUsuario.addNewUsuario(new Usuario(usuario.getNombre(), usuario.getEmail(), passwordEncoder.encode(usuario.getContrasena()), usuario.getRol()));
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
