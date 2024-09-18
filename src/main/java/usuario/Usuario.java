package usuario;

import lombok.Getter;
import lombok.Setter;

public class Usuario {
    @Setter @Getter
    String nombre;
    @Setter @Getter
    String email;
    @Setter @Getter
    String contraseña;
    @Setter @Getter
    int id;
    Rol rol;

    public Usuario() {
    }
    public Usuario(int id, String email, String nombre, String contraseña, Rol rol) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.rol = rol;

    }

    @Override
    public String toString() {
        return "Usuario [" +
                "Nombre: " + nombre + '\'' + "; Rol:"
                + rol + '\'' + "; Email:" + email +
                '\'' + "; Contraseña:" + contraseña
                + '\'' + " ID: " + id +
                ']';
    }
}
