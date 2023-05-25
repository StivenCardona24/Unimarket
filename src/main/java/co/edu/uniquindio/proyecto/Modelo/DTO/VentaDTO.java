package co.edu.uniquindio.proyecto.Modelo.DTO;


import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoVenta;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public  class VentaDTO {
    private double totalCompra;

    private EstadoVenta estado;

    private MetodoPago metodoPago;
    private int tajetaCompra;
    private int usuario;

    private LocalDate fechaCompra;
    private EstadoObjeto estadoObjeto;
}