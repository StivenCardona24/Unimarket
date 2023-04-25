package co.edu.uniquindio.proyecto.Modelo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.File;

@AllArgsConstructor
@Getter
@Setter
public class ImagenDTO {

    private File file;

    private String carpeta;


}
