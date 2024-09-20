package com.starksecurity.backend.repositorios;

import com.starksecurity.backend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

    @Query("SELECT s from Usuario s where s.email = ?1")
    Optional<Usuario> findUsuarioByEmail(String email);
}
