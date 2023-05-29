package co.edu.uniquindio.proyecto.Modelo.DTO;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductoGetDTO {
    private int codigo;

    private EstadoProducto estado;

    private LocalDate fechaLimite;

    private String nombre;

    private String descripcion;

    private int unidades;

    private double precio;

    private int codigoVendedor;

    private Map<String,String> imagenes;

    private List<Categoria> categorias;
}
