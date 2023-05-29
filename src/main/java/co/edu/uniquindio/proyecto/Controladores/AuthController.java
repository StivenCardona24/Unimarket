package co.edu.uniquindio.proyecto.Controladores;


import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.SesionDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.SesionServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {
    private final UsuarioServicio usuarioServicio;
    private final SesionServicio sesionServicio;
    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login(@Valid @RequestBody SesionDTO loginUser) {
        System.out.println(loginUser.getEmail() + loginUser.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                sesionServicio.login(loginUser)) );
    }
    @PostMapping("/registro")
    public ResponseEntity<MensajeDTO> registrarCliente( @RequestBody UsuarioDTO usuarioDto) throws Exception {
        usuarioServicio.crearUsuario(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,
                false, "Usuario creado correctamente"));
    }
}
