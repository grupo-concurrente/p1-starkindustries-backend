package com.starksecurity.backend.servicios;

import com.starksecurity.backend.modelos.Usuario;
import com.starksecurity.backend.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private RepositorioUsuario usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Obtener el usuario como Optional
        Optional<Usuario> optionalUsuario = usuarioRepositorio.findUsuarioByEmail(email);

        // Comprobar si existe
        Usuario usuario = optionalUsuario.orElseThrow(() ->
                new UsernameNotFoundException("Usuario no encontrado con el email: " + email)
        );

        // Retornar un UserDetails con la información del usuario y su rol
        return User.withUsername(usuario.getEmail())
                .password(usuario.getContrasena())
                .roles(usuario.getRol().name()) // Asegúrate de que el rol sea un array de Strings
                .build();
    }
}
