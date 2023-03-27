package co.edu.uniquindio.proyecto.Modelo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CiudadDTO {
    @Length(max =50,message = "error nombre demaciado largo")
    private String nombre;
}
