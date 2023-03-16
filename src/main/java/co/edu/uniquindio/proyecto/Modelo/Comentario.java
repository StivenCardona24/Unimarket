package co.edu.uniquindio.proyecto.Modelo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Comentario implements Serializable{
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDate fecha;
    @NotNull
    @Lob
    private Long comentario;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    private Usuario usuario;


}
