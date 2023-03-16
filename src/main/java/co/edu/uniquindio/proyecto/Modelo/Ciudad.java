package co.edu.uniquindio.proyecto.Modelo;
import jakarta.persistence.*;
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
public class Ciudad implements Serializable{
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(nullable = false,length = 50)
    private String nombre;
    @ManyToOne
    private Departamento departamento;
    @OneToMany(mappedBy="ciudad")
    private List<Usuario> usuarios;
}
