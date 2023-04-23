package co.edu.uniquindio.proyecto.Controladores;


import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ComentarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/Comentario")
@AllArgsConstructor
public class ComentarioControler {

    @Autowired
    private final ComentarioServicio comentarioServicio;

    @DeleteMapping("/eliminarCiudad/{codigo}")
    public ResponseEntity<MensajeDTO> geteliminarCiudad(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                comentarioServicio.eliminarComentario(codigo) ));
    }

    @PutMapping("/update/{codigo}")
    public ResponseEntity<MensajeDTO> update(@PathVariable int codigo, @Valid @RequestBody ComentarioDTO comentarioDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                comentarioServicio.actualizarComentario(codigo, comentarioDTO) ) );
    }

    @PostMapping("/create")
    public ResponseEntity<MensajeDTO> create(@Valid @RequestBody ComentarioDTO comentarioDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Ciudad creado correctamente"+comentarioServicio.crearComentario(comentarioDTO)));
    }

    @GetMapping("/getObtenerComentario/{codigo}")
    public ResponseEntity<MensajeDTO> getObtenerComentario(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                comentarioServicio.obtenerComentario(codigo) ));
    }

    @GetMapping("/countComentarioProducto/{codigo}")
    public ResponseEntity<MensajeDTO> getCountComentarioProducto(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                comentarioServicio.countComentarioProducto(codigo) ));
    }

    @GetMapping("/listarComentariostexto/{texto}")
    public ResponseEntity<MensajeDTO> getListarComentariostexto(@PathVariable String texto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                comentarioServicio.listarComentariostexto(texto) ));
    }

    @GetMapping("/listarComentariosFecha/{fecha}")
    public ResponseEntity<MensajeDTO> getListarComentariosFecha(@PathVariable LocalDate fecha) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                comentarioServicio.listarComentariosFecha(fecha) ));
    }

    @GetMapping("/listarComentariosUsuario/{codigo}")
    public ResponseEntity<MensajeDTO> getListarComentariosUsuario(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                comentarioServicio.listarComentariosUsuario(codigo) ));
    }

    @GetMapping("/listarComentariosUsuarioCedula/{cedula}")
    public ResponseEntity<MensajeDTO> getListarComentariosUsuarioCedula(@PathVariable String cedula) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                comentarioServicio.listarComentariosUsuarioCedula(cedula) ));
    }

    @GetMapping("/listarComentariosProducto/{codigo}")
    public ResponseEntity<MensajeDTO> getListarComentariosProducto(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                comentarioServicio.listarComentariosProducto(codigo) ));
    }

}
