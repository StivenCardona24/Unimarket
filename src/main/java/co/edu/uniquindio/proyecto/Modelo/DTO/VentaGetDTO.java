package co.edu.uniquindio.proyecto.Modelo.DTO;


import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoVenta;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter

public  class VentaGetDTO {
    private int idVenta;
    private LocalDate fechaCompra;
    private double totalCompra;

    private EstadoVenta estado;

    private MetodoPago metodoPago;
    private int tajetaCompra;
    private int usuario;
    private List<DetalleVentaDTO> ventaProducto;
}