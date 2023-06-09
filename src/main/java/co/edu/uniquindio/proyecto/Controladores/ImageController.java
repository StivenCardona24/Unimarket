package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.Modelo.DTO.ImagenDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.Servicios.Implementacion.CloudinaryServicioImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("api/imagenes")
@AllArgsConstructor
public class ImageController {

    @Autowired
    private CloudinaryServicioImpl cloudinaryServicio;

    @PostMapping
    public ResponseEntity<MensajeDTO> create(@RequestParam("file") MultipartFile file) throws Exception {
        File imagen = cloudinaryServicio.convertir(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.OK, false,   cloudinaryServicio.subirImagen( imagen, "productos/")));
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> eliminar(@PathVariable String codigo) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false,   cloudinaryServicio.eliminarImagen(codigo)));
    }
}
