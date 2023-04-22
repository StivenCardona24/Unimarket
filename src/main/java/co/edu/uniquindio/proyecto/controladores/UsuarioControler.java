package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
@AllArgsConstructor
public class UsuarioControler {
    @Autowired
    private final UsuarioServicio usuarioServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, usuarioServicio.crearUsuario(usuarioDTO)) );


    }

    @DeleteMapping("/eliminar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> eliminarUsuario(@PathVariable int codigoUsuario) throws Exception{
        usuarioServicio.eliminarUsuario(codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Usuario eliminado correctamente") );
    }

    @PutMapping("/actualizar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> actualizarUsuario(@PathVariable int codigoUsuario, @RequestBody UsuarioDTO usuarioDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, usuarioServicio.actualizarUsuario(codigoUsuario, usuarioDTO)));
    }



    @GetMapping("/obtener/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> obtenerUsuario(@PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, usuarioServicio.obtenerUsuario(codigoUsuario)));
    }

    @GetMapping("/obtener/{gmail}")
    public ResponseEntity<MensajeDTO> obtenerUsuarioporCorreo(@PathVariable String  gmail) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, usuarioServicio.obtenerporCorreo(gmail)));
    }



 /*   Usuario obtener (int codigoUsuario) {

        return null;
    }


*/

}