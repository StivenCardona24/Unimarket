package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
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
@RequestMapping("api/EstadoObjeto")
@AllArgsConstructor
public class EstadoObjetoController {

    @GetMapping("/buscarPorEstado")
    public ResponseEntity<EstadoObjeto> buscarPorEstado(@RequestParam EstadoObjeto estado) {
        EstadoObjeto entidades = obtenerEntidadesPorEstado(estado);
        return ResponseEntity.ok(entidades);
    }

    @GetMapping("/estados")
    public ResponseEntity<List<String>> obtenerEstados() {
        List<String> estados = Arrays.stream(EstadoObjeto.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(estados);
    }

    public EstadoObjeto obtenerEntidadesPorEstado(EstadoObjeto estado) {
        for (EstadoObjeto entidad : EstadoObjeto.values()) {
            if (entidad== estado) {
                return entidad;
            }
        }
        return null;
    }
}
