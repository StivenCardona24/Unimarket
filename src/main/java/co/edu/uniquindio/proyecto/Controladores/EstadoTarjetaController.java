package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoTarjeta;
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
@RequestMapping("api/EstadoTarjeta")
@AllArgsConstructor
public class EstadoTarjetaController {

    @GetMapping("/buscarPorEstado")
    public ResponseEntity<EstadoTarjeta> buscarPorEstado(@RequestParam EstadoTarjeta estado) {
        EstadoTarjeta entidades = obtenerEntidadesPorEstado(estado);
        return ResponseEntity.ok(entidades);
    }

    @GetMapping("/estados")
    public ResponseEntity<List<String>> obtenerEstados() {
        List<String> estados = Arrays.stream(EstadoTarjeta.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(estados);
    }

    public EstadoTarjeta obtenerEntidadesPorEstado(EstadoTarjeta estado) {
        for (EstadoTarjeta entidad : EstadoTarjeta.values()) {
            if (entidad== estado) {
                return entidad;
            }
        }
        return null;
    }
}
