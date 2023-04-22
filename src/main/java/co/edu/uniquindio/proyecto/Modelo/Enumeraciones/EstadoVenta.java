package co.edu.uniquindio.proyecto.Modelo.Enumeraciones;
import lombok.*;

import java.io.Serializable;
//@Enumerated(EnumType.STRING)
@Getter
@NoArgsConstructor
@ToString
public enum EstadoVenta implements Serializable{
    CARRITO,
    SOLICITADO,
    PAGADO,
    ENTREGADO,
    CANCELADO

}
