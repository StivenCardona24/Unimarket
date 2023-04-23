package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("api/ciudad")
@AllArgsConstructor
public class CiudadControler {

    @Autowired
    private final CiudadServicio ciudadServicio;

    @GetMapping("/getAll")
    public List<CiudadGetDTO> getAll() throws Exception {
        return ciudadServicio.obtenerCiudades();
    }
    @DeleteMapping("/eliminar/{codigoCiudad}")
    public ResponseEntity<MensajeDTO> delete(@PathVariable int codigoCiudad) throws Exception {
        int num  = ciudadServicio.eliminarCiudad(codigoCiudad);
        return (ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                "Eliminado correctamente" )) );
    }
    @GetMapping("/obtenerCiudad/{codigo}")
    public ResponseEntity<MensajeDTO> getObtenerCiudad(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                ciudadServicio.obtenerCiudad(codigo) ));
    }

}
