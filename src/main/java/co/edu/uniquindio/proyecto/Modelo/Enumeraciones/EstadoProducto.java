package co.edu.uniquindio.proyecto.Modelo.Enumeraciones;
import lombok.*;

import java.io.Serializable;
//@Enumerated(EnumType.ORDINAL)
@Getter
@NoArgsConstructor
@ToString
public enum EstadoProducto implements Serializable{
    ACTIVE,
    INACTIVE,
    EN_APROBACION;
}
