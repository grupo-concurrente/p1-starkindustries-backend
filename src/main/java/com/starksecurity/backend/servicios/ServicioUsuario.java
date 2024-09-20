package com.starksecurity.backend.servicios;

import com.starksecurity.backend.modelos.Usuario;
import com.starksecurity.backend.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario {

    private final RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public List<Usuario> getUsuarios() {
        return repositorioUsuario.findAll();
    }

    public void addNewUsuario(Usuario usuario) {
        Optional<Usuario> usuarioPorEmail = repositorioUsuario.findUsuarioByEmail(usuario.getEmail());
        if (usuarioPorEmail.isPresent()) {
            throw new IllegalArgumentException("El email ya existe");
        }

        repositorioUsuario.save(usuario);
    }
}
