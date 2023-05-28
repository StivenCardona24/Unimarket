package co.edu.uniquindio.proyecto.Controladores;


import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Role;
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
@RequestMapping("api/Role")
@AllArgsConstructor
public class RoleController {

    @GetMapping("/buscarPorEstado")
    public ResponseEntity<Role> buscarPorEstado(@RequestParam Role estado) {
        Role entidades = obtenerEntidadesPorEstado(estado);
        return ResponseEntity.ok(entidades);
    }

    @GetMapping
    public ResponseEntity<List<String>> obtenerEstados() {
        List<String> estados = Arrays.stream(Role.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(estados);
    }

    public Role obtenerEntidadesPorEstado(Role estado) {
        for (Role entidad : Role.values()) {
            if (entidad== estado) {
                return entidad;
            }
        }
        return null;
    }
}
