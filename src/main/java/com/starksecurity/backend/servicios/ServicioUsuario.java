package com.starksecurity.backend.servicios;

import com.starksecurity.backend.modelos.Usuario;
import com.starksecurity.backend.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario implements UserDetailsService {

    private final RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }


    // En ServicioUsuario.java
    public Optional<Usuario> getUsuarioByEmail(String email) {
        return repositorioUsuario.findUsuarioByEmail(email);
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = repositorioUsuario.findUsuarioByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No se encontró el usuario con el email: " + email));
        return new User(usuario.getEmail(), usuario.getContrasena(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+usuario.getRol().name())));
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
}
