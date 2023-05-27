package co.edu.uniquindio.proyecto.Modelo.DTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioDTO {
    @NotBlank(message = "El comentario no puede estar vacío")
    @NotNull(message = "El comentario no puede ser nulo")
    @Size(max = 500, message = "El comentario debe tener maximo 500 caracteres")
    private String comentario;

    @NotNull(message = "El id del Producto no puede ser nulo")
    private int idProducto;

    @NotNull(message = "El id del Usuario no puede ser nulo")
    private int idUsuario;
    private EstadoObjeto estadoObjeto;
}
