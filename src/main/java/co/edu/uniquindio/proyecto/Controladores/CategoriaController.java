package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/Categoria")
@AllArgsConstructor
public class CategoriaController {

    @GetMapping("/buscarPorEstado")
    public ResponseEntity<Categoria> buscarPorEstado(@RequestParam Categoria estado) {
        Categoria entidades = obtenerEntidadesPorEstado(estado);
        return ResponseEntity.ok(entidades);
    }

    @GetMapping("/")
    public ResponseEntity<List<String>> obtenerEstados() {
        List<String> estados = Arrays.stream(Categoria.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(estados);
    }

    public Categoria obtenerEntidadesPorEstado(Categoria estado) {
        for (Categoria entidad : Categoria.values()) {
            if (entidad== estado) {
                return entidad;
            }
        }
        return null;
    }
}
