package co.edu.uniquindio.proyecto.Controladores;


import co.edu.uniquindio.proyecto.Modelo.DTO.LicenciaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.LicenciaServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/licencias")
@AllArgsConstructor
public class LicenciaController {

    @Autowired
    public final LicenciaServicio licenciaServicio;

    @GetMapping
    public ResponseEntity<MensajeDTO> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false,
                licenciaServicio.listarLicencias()));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> getOne(@PathVariable int codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                licenciaServicio.obtenerLicencia(codigo)));
    }

    @PostMapping
    public ResponseEntity<MensajeDTO> create(@Valid @RequestBody LicenciaDTO licencia) throws Exception {
        licenciaServicio.crearLicencia(licencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Cliente creado correctamente"));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> update(@PathVariable int codigo, @Valid @RequestBody LicenciaDTO licencia) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                licenciaServicio.actualizarLicencia(codigo, licencia) ) );
    }
}