package usuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuario") // localhost:8080/api/v1/usuario
public class ControladorUsuario {

    @GetMapping
    public List<Usuario> getUsuarios() {
        return List.of(
                new Usuario(1, "email@email.com", "nombre", "contraseña", Rol.ADMINISTRADOR)
        );
    }
}
