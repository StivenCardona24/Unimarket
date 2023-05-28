package co.edu.uniquindio.proyecto.Controladores;


import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoVenta;
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
@RequestMapping("api/EstadoVenta")
@AllArgsConstructor
public class EstadoVentaController {

    @GetMapping("/buscarPorEstado")
    public ResponseEntity<EstadoVenta> buscarPorEstado(@RequestParam EstadoVenta estado) {
        EstadoVenta entidades = obtenerEntidadesPorEstado(estado);
        return ResponseEntity.ok(entidades);
    }

    @GetMapping
    public ResponseEntity<List<String>> obtenerEstados() {
        List<String> estados = Arrays.stream(EstadoVenta.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(estados);
    }

    public EstadoVenta obtenerEntidadesPorEstado(EstadoVenta estado) {
        for (EstadoVenta entidad : EstadoVenta.values()) {
            if (entidad== estado) {
                return entidad;
            }
        }
        return null;
    }
}
