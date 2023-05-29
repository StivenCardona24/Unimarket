package co.edu.uniquindio.proyecto.Modelo.Enumeraciones;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public enum EstadoObjeto {
    //Estados que indicaran en el objeto si es visible o no o para eliminar
    ACTIVE,
    INACTIVE
}
