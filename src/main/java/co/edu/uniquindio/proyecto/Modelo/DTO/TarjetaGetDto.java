package co.edu.uniquindio.proyecto.Modelo.DTO;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoTarjeta;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.TipoTarjeta;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TarjetaGetDto {

    private Integer codigo;

    private String numero;

    private String CVV;

    private String nombre;

    private LocalDate fecha;

    private double dinero;


    private EstadoTarjeta estado;

    private TipoTarjeta tipo;



    private List<UsuarioDTO> usuario;


    private List<TokenDTO.VentaDTO> compras;
}
