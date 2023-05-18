package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
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

    @GetMapping("/{estado}/precioMin/{precioMin}/precioMax/{precioMax}/nombre/{nombre}")
    public ResponseEntity<MensajeDTO> findProductoProductosCategoriaPrecioNombre(@PathVariable Categoria categoria,@PathVariable double precioMin,@PathVariable double precioMax,@PathVariable String nombre) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                productoServicio.findProductoProductosCategoriaPrecioNombre(categoria,precioMin,precioMax,nombre)));
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

    @DeleteMapping("/{codigoProducto}")
    public ResponseEntity<MensajeDTO> delete(@PathVariable int codigoProducto) throws Exception {
        int num  = productoServicio.eliminarProducto(codigoProducto);

        return (ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                "Eliminado correctamente" )) );
    }

    @PutMapping("/{codigo}/unidades/{unidades}")
    public ResponseEntity<MensajeDTO> updateUnidades(@PathVariable int codigo, @PathVariable int unidades) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                productoServicio.actualizarUnidades(codigo, unidades) ) );
    }

    @PutMapping("/{codigo}/estado/{estado}")
    public ResponseEntity<MensajeDTO> updateEstado(@PathVariable int codigo, @PathVariable EstadoProducto estado) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                productoServicio.actualizarEstado(codigo, estado) ) );
    }


    @GetMapping("/usuario/{codigo}")
    public ResponseEntity<MensajeDTO> getUsuario(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                productoServicio.listarProductosUsuario(codigo) ));
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<MensajeDTO> getCategoria(@PathVariable Categoria categoria) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                productoServicio.listarProductosCategoria(categoria) ));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<MensajeDTO> getEstado(@PathVariable EstadoProducto estado) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                productoServicio.listarProductosPorEstado(estado) ));
    }

    @GetMapping("/favorito/{codigo}")
    public ResponseEntity<MensajeDTO> getFavoritos(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                productoServicio.listarProductosFavoritos(codigo) ) );
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<MensajeDTO> getNombre(@PathVariable String nombre) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                productoServicio.listarProductosNombre(nombre) ) );
    }

    @GetMapping("/precio/{precioMin}/{precioMax}")
    public ResponseEntity<MensajeDTO> getPrecio(@PathVariable double precioMin, @PathVariable double precioMax) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                productoServicio.listarProductosPrecio(precioMin, precioMax) ) );
    }







}
