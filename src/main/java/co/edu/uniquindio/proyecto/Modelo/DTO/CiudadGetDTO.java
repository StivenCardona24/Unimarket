package co.edu.uniquindio.proyecto.Modelo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
@AllArgsConstructor
@Getter
@Setter
public class CiudadGetDTO {

    private Integer codigo;
    @Length(max =50,message = "error nombre demaciado largo")
    private String nombre;

}
