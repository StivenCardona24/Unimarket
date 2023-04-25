package co.edu.uniquindio.proyecto.Modelo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DetalleVentaGetDTO {
    private int idDetalleVenta;
    private int unidades;
    private double precioUnitario;
    private int idVenta;
    private int idProducto;
}
