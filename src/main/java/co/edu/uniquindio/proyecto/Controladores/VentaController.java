package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.DTO.*;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoVenta;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.TarjetaServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.VentaServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ventas")
@AllArgsConstructor
public class VentaController {

    @Autowired
    private final VentaServicio  ventaServicio;


    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearVenta(@RequestBody VentaDTO ventaDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, ventaServicio.crearVenta(ventaDTO)) );


    }



    @GetMapping("/listar/{codigoVenta}")
    public ResponseEntity<MensajeDTO> getUsuario(@PathVariable int codigoVenta) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                ventaServicio.obtenerVenta(codigoVenta) ));
    }



    @GetMapping("/obtenerCodigo/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> getOne(@PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, ventaServicio.listarVentaUsuarios(codigoUsuario)));
    }

    @PutMapping("{codigo}/estado/{estado}")
    public  ResponseEntity<MensajeDTO> actualizarEstado(@PathVariable int codigo, @PathVariable EstadoVenta estado) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, ventaServicio.actualizarEstado(codigo, estado)));
    }

    @PutMapping("/eliminarVenta/{codigo}")
    public  ResponseEntity<MensajeDTO> actualizarEstadoObjeto(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, ventaServicio.eliminarVenta(codigo)));
    }

}
