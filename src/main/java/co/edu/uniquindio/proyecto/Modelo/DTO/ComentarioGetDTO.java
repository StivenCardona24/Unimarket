package co.edu.uniquindio.proyecto.Modelo.DTO;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ComentarioGetDTO {
    private int idComentario;

    private LocalDate fechaComentario;

    private String comentario;

    private int idProducto;

    private int idUsuario;
}