package co.edu.uniquindio.proyecto.Modelo;
import lombok.*;

import java.io.Serializable;
//@Enumerated(EnumType.STRING)
@Getter
@NoArgsConstructor
@ToString
public enum EstadoVenta implements Serializable{
    ACTIVE,
    INACTIVE
}
