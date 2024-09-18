package com.starksecurity.backend.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @Setter @Getter
    private String nombre;

    @Setter @Getter
    private String email;

    @Setter @Getter
    private String contrasena;

    @Enumerated(EnumType.STRING)
    Rol rol;

    public Usuario() {
    }

    public Usuario(long id, String email, String nombre, String contrasena, Rol rol) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public Usuario(String email, String nombre, String contrasena, Rol rol) {
        this.email = email;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario [" +
                "Nombre: " + nombre + '\'' + "; Rol:"
                + rol + '\'' + "; Email:" + email +
                '\'' + "; Contraseña:" + contrasena
                + '\'' + " ID: " + id +
                ']';
    }
}
