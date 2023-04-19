package co.edu.uniquindio.proyecto.Modelo.DTO;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductoDTO {
    //anotaciones validcacion
    //extends trow
    @Length(max =100,message = "error nombre|")
    private String nombre;
    private String descripcion;
    private int vendedor;
    private int unidades;
    private double  precio;
   private Map< String, String> imagenes;
     private List<Categoria> categorias;
}
