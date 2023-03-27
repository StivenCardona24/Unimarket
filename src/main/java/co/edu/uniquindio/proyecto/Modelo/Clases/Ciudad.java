package co.edu.uniquindio.proyecto.Modelo.Clases;
import jakarta.persistence.*;
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
    @GeneratedValue
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(length = 50,nullable = false)
    private String nombre;
    @ToString.Exclude
    @OneToMany(mappedBy="ciudad")
    private List<Usuario> usuarios;
}
