package co.edu.uniquindio.proyecto.Modelo.Clases;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Ciudad implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(length = 50,nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    private EstadoObjeto estadoObjeto;
    @ToString.Exclude
    @OneToMany(mappedBy="ciudad")
    private List<Usuario> usuarios;
}
