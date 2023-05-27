package co.edu.uniquindio.proyecto.Modelo.DTO;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LicenciaGetDTO {

    private int codigo;

    private String nombre;

    private double precioUnitario;

    private int diasActivoProducto;

    private int prioridad;
    private EstadoObjeto estadoObjeto;
}
