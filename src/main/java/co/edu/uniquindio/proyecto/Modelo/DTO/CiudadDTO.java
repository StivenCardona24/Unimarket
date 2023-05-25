package co.edu.uniquindio.proyecto.Modelo.DTO;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CiudadDTO {
    @Length(max =50,message = "error nombre demaciado largo")
    private String nombre;
    private EstadoObjeto estadoObjeto;
}
