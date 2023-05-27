package co.edu.uniquindio.proyecto.Modelo.DTO;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CiudadGetDTO {

    private Integer codigo;
    @Length(max =50,message = "error nombre demaciado largo")
    private String nombre;
    private EstadoObjeto estadoObjeto;

    private List<UsuarioDTO> usuarios;

}
