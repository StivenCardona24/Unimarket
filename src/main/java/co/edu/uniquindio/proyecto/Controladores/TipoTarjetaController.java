package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.TipoTarjeta;
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
@RequestMapping("api/TipoTarjeta")
@AllArgsConstructor
public class TipoTarjetaController {

    @GetMapping("/buscarPorEstado")
    public ResponseEntity<TipoTarjeta> buscarPorEstado(@RequestParam TipoTarjeta estado) {
        TipoTarjeta entidades = obtenerEntidadesPorEstado(estado);
        return ResponseEntity.ok(entidades);
    }

    @GetMapping
    public ResponseEntity<List<String>> obtenerEstados() {
        List<String> estados = Arrays.stream(TipoTarjeta.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(estados);
    }

    public TipoTarjeta obtenerEntidadesPorEstado(TipoTarjeta estado) {
        for (TipoTarjeta entidad : TipoTarjeta.values()) {
            if (entidad== estado) {
                return entidad;
            }
        }
        return null;
    }
}
