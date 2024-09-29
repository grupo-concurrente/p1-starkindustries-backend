package com.starksecurity.backend.servicios;

import com.starksecurity.backend.modelos.Usuario;
import com.starksecurity.backend.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder; // Importa el PasswordEncoder
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario {

    private final RepositorioUsuario repositorioUsuario;

    //private final PasswordEncoder passwordEncoder; // PasswordEncoder para verificar contraseñas

    @Autowired
    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }


    // Obtener todos los usuarios
    public List<Usuario> getUsuarios() {
        return repositorioUsuario.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuario> getUsuarioById(Long id) {
        return repositorioUsuario.findById(id);
    }

    // Agregar un nuevo usuario
    public void addNewUsuario(Usuario usuario) {
        Optional<Usuario> usuarioPorEmail = repositorioUsuario.findUsuarioByEmail(usuario.getEmail());
        if (usuarioPorEmail.isPresent()) {
            throw new IllegalArgumentException("El email ya existe");
        }
        repositorioUsuario.save(usuario);
    }

    // Eliminar un usuario por ID
    public void deleteUsuario(Long id) {
        boolean exists = repositorioUsuario.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El usuario con id " + id + " no existe.");
        }
        repositorioUsuario.deleteById(id);
    }

    // Actualizar un usuario por ID
    public void updateUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuario = repositorioUsuario.findById(id)
                .orElseThrow(() -> new IllegalStateException("El usuario con id " + id + " no existe."));

        if (usuarioActualizado.getNombre() != null && !usuarioActualizado.getNombre().isEmpty()) {
            usuario.setNombre(usuarioActualizado.getNombre());
        }

        if (usuarioActualizado.getEmail() != null && !usuarioActualizado.getEmail().isEmpty()) {
            Optional<Usuario> usuarioPorEmail = repositorioUsuario.findUsuarioByEmail(usuarioActualizado.getEmail());
            if (usuarioPorEmail.isPresent()) {
                throw new IllegalArgumentException("El email ya existe");
            }
            usuario.setEmail(usuarioActualizado.getEmail());
        }

        if (usuarioActualizado.getContrasena() != null && !usuarioActualizado.getContrasena().isEmpty()) {
            usuario.setContrasena(usuarioActualizado.getContrasena());
        }

        if (usuarioActualizado.getRol() != null) {
            usuario.setRol(usuarioActualizado.getRol());
        }

        repositorioUsuario.save(usuario);
    }
/*
    // Método para verificar si el usuario existe y la contraseña es correcta
    public boolean verificarUsuario(String email, String rawPassword) {
        Optional<Usuario> usuarioOpt = repositorioUsuario.findUsuarioByEmail(email);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            // Verificar si la contraseña ingresada coincide con la cifrada almacenada
            return passwordEncoder.matches(rawPassword, usuario.getContrasena());
        }

        return false; // Si el usuario no existe o la contraseña no coincide
    }

 */
}