package co.edu.uniquindio.proyecto.Controladores;


import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.MetodoPago;
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
@RequestMapping("api/MetodoPago")
@AllArgsConstructor
public class MetodoPagoController {

    @GetMapping("/buscarPorEstado")
    public ResponseEntity<MetodoPago> buscarPorEstado(@RequestParam MetodoPago estado) {
        MetodoPago entidades = obtenerEntidadesPorEstado(estado);
        return ResponseEntity.ok(entidades);
    }

    @GetMapping("/estados")
    public ResponseEntity<List<String>> obtenerEstados() {
        List<String> estados = Arrays.stream(MetodoPago.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(estados);
    }

    public MetodoPago obtenerEntidadesPorEstado(MetodoPago estado) {
        for (MetodoPago entidad : MetodoPago.values()) {
            if (entidad== estado) {
                return entidad;
            }
        }
        return null;
    }
}
