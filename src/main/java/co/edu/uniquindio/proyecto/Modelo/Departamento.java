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
public class Departamento implements Serializable{
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(nullable = false,length = 40)
    private String nombre;

    @ManyToOne
    private Pais pais;
    @OneToMany(mappedBy="departamento")
    private List<Ciudad> ciudades;
}
