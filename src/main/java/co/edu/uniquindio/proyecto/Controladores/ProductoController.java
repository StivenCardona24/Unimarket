package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("api/productos")
@AllArgsConstructor
public class ProductoController {

    @Autowired
    private final ProductoServicio productoServicio;

    @GetMapping
    public List<ProductoGetDTO> getAll(){
        return productoServicio.listarProductos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> getOne(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                productoServicio.obtenerProducto(codigo)));
    }

    @PostMapping
    public ResponseEntity<MensajeDTO> create(@Valid @RequestBody ProductoDTO producto) throws Exception {
        productoServicio.crearProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Cliente creado correctamente"));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> update(@PathVariable int codigo, @Valid @RequestBody ProductoDTO producto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                productoServicio.actualizarProducto(codigo, producto) ) );
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> delete(@PathVariable int codigo) throws Exception {
        int num  = productoServicio.eliminarProducto(codigo);

        return (ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                "Eliminado correctamente" )) );
    }


}
