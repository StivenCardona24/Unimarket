package co.edu.uniquindio.proyecto.Modelo.DTO;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductoDTO {
    //anotaciones validcacion
    //extends trow
    @Length(max =100,message = "error nombre|")
    private String nombre;
    private String descripocion;
    private int vendedor;
    private int unidades;
    private double  precio;
    private List<String> imagenes;
    private List<String> categoria;
}
