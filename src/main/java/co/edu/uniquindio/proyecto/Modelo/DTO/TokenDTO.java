package co.edu.uniquindio.proyecto.Modelo.DTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoVenta;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.MetodoPago;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
    @NotNull
    private String token;

    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    public static class VentaDTO {
        private double totalCompra;

        private EstadoVenta estado;

        private MetodoPago metodoPago;
        private int tajetaCompra;
        private int usuario;

        private LocalDate fechaCompra;

    }
}