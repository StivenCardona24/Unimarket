package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.DTO.*;
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
                ventaServicio.listarVentaUsuarios(codigoVenta) ));
    }



    @GetMapping("/obtenerCodigo/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> getOne(@PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, ventaServicio.obtenerVenta(codigoUsuario)));
    }



}
