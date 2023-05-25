package co.edu.uniquindio.proyecto.Modelo.DTO;


import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

@AllArgsConstructor
@Getter
@Setter
public class LicenciaDTO {

    @NotNull(message = "el nombre no puede ser nulo")
    @NotBlank(message = "el nombre no puede estar vacio")
    @Length(message = "El nombre no debe ser mas grande de 100 caracteres",max = 100)
    private String nombre;

    @NotEmpty
    @NotNull(message = "El precio no puede ser nulo")
    @NumberFormat
    private double  precio;

    @NotNull(message = "Los dias no puede ser nulo")
    @NumberFormat
    private int diasActivoProducto;

    @NotNull(message = "La prioridad no puede ser nula")
    @NumberFormat
    private int prioridad;
    private EstadoObjeto estadoObjeto;
}
