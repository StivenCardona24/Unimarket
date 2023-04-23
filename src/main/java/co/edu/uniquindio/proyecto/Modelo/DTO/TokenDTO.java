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


}