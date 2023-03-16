package co.edu.uniquindio.proyecto.Modelo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Licencia implements Serializable{
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(nullable = false, length = 30)
    @NotNull
    private String nombre;
    @Column(nullable = false)
    @Min(20)
    @Max(1000)
    private int diasActivoProducto;
    @Column(nullable = false)
    @Min(1)
    @Max(10)
    private int prioridad;
    @OneToMany(mappedBy="licencia")
    private List<Usuario> usuarios;
}
