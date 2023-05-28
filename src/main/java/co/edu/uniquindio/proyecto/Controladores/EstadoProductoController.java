package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/EstadoProducto")
@AllArgsConstructor
public class EstadoProductoController {

    @GetMapping("/buscarPorEstado")
    public ResponseEntity<EstadoProducto> buscarPorEstado(@RequestParam EstadoProducto estado) {
        EstadoProducto entidades = obtenerEntidadesPorEstado(estado);
        return ResponseEntity.ok(entidades);
    }

    @GetMapping
    public ResponseEntity<List<String>> obtenerEstados() {
        List<String> estados = Arrays.stream(EstadoProducto.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(estados);
    }

    public EstadoProducto obtenerEntidadesPorEstado(EstadoProducto estado) {
        for (EstadoProducto entidad : EstadoProducto.values()) {
            if (entidad== estado) {
                return entidad;
            }
        }
        return null;
    }
}
