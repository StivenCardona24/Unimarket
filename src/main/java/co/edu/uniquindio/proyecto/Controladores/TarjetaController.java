package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.TarjetaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.TarjetaGetDto;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.TarjetaServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Tarjetas")
@AllArgsConstructor
public class TarjetaController {
    @Autowired
    private final TarjetaServicio tarjetaServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearTarjeta(@RequestBody TarjetaDTO tarjetaDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, tarjetaServicio.crearTarjeta(tarjetaDTO)) );


    }

    @GetMapping("/obtenerCodigo/{codigoTarjeta}")
    public ResponseEntity<MensajeDTO> obtenerTarjeta(@PathVariable int codigoTarjeta) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, tarjetaServicio.obtenerTarjeta(codigoTarjeta)));
    }

    @DeleteMapping("/eliminar/{codigoTarjeta}")
    public ResponseEntity<MensajeDTO> eliminarUsuario(@PathVariable int codigoTarjeta) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, tarjetaServicio.eliminarTarjeta(codigoTarjeta)) );
    }


    @PutMapping("/actualizar/{codigoTarjeta}")
    public ResponseEntity<MensajeDTO> actualizarUsuario(@PathVariable int codigoTarjeta, @RequestBody TarjetaDTO terjetaDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, tarjetaServicio.actualizarTarjeta(codigoTarjeta, terjetaDTO)));
    }

    @GetMapping("/listar/{codigo}")
    public ResponseEntity<MensajeDTO> obtenerTajertasUsuario(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                tarjetaServicio.obtenerTajertasUsuario(codigo) ));
    }








}
