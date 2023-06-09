package co.edu.uniquindio.proyecto.Modelo.DTO;

import lombok.*;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductoDTO {
    //anotaciones validcacion
    //extends trow
    @NotNull(message = "el nombre no puede ser nulo")
    @NotBlank(message = "el nombre no puede estar vacio")
    @Length(max =100,message = "El nombre no puede susperar más de 100 caracteres")
    private String nombre;

    @NotNull(message = "La descripcion no puede ser nula")
    @NotBlank(message = "La descripcion no puede estar vacia")
    @Length(max =1000,message = "El descripcion no puede susperar más de 1000 caracteres")
    private String descripcion;


    @NumberFormat
    private int vendedor;


    @NumberFormat
    private int unidades;


    @NumberFormat
    private double  precio;


   private Map< String, String> imagenes;


   private List<Categoria> categorias;
}
