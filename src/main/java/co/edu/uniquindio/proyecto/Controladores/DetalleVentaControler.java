package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.DTO.DetalleVentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.DetalleVentaServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/detalleVenta")
@AllArgsConstructor
public class DetalleVentaControler {
    @Autowired
    private final DetalleVentaServicio detalleVentaServicio;

    @PostMapping("/create")
    public ResponseEntity<MensajeDTO> create(@Valid @RequestBody DetalleVentaDTO detalleVentaDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "DetalleVenta creado correctamente"+detalleVentaServicio.crearDetalleVenta(detalleVentaDTO)));
    }

    @PutMapping("/update/{codigo}")
    public ResponseEntity<MensajeDTO> update(@PathVariable int codigo, @Valid @RequestBody DetalleVentaDTO detalleVentaDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                detalleVentaServicio.actualizarDetalleVenta(codigo, detalleVentaDTO) ) );
    }

    @DeleteMapping("/eliminarDetalleVenta/{codigo}")
    public ResponseEntity<MensajeDTO> geteliminarCiudad(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                detalleVentaServicio.eliminarDetalleVenta(codigo) ));
    }

    @GetMapping("/getObtenerDetalleVenta/{codigo}")
    public ResponseEntity<MensajeDTO> getObtenerDetalleVenta(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                detalleVentaServicio.obtenerDetalleVenta(codigo) ));
    }

    @GetMapping("/getObtenerDetalleVentaPorVenta/{codigo}")
    public ResponseEntity<MensajeDTO> getObtenerDetalleVentaPorVenta(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                detalleVentaServicio.obtenerDetalleVentaPorVenta(codigo) ));
    }

    @GetMapping("/getObtenerDetalleVentaProducto/{codigo}")
    public ResponseEntity<MensajeDTO> getObtenerDetalleVentaProducto(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                detalleVentaServicio.obtenerDetalleVentaProducto(codigo) ));
    }
    @GetMapping("/getfindAllByProductoNombre/{nombre}")
    public ResponseEntity<MensajeDTO> getfindAllByProductoNombre(@PathVariable String nombre) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                detalleVentaServicio.findAllByProductoNombre(nombre) ));
    }


}
