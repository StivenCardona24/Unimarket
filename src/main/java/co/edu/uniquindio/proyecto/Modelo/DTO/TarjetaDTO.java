package co.edu.uniquindio.proyecto.Modelo.DTO;

import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoTarjeta;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.TipoTarjeta;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TarjetaDTO {


    private String numero;

    private String CVV;

    private String nombre;

    private LocalDate fecha;

    private double dinero;

    private EstadoTarjeta estado;

    private TipoTarjeta tipo;

}


