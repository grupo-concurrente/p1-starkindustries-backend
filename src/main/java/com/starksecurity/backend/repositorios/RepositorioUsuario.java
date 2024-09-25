package com.starksecurity.backend.repositorios;

import com.starksecurity.backend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    Optional<Usuario> findUsuarioByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.nombre = ?1")
    Optional<Usuario> findUsuarioByNombre(String nombre);


}
