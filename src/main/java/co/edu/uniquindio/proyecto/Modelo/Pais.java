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
public class Pais implements Serializable{
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(nullable = false,length = 30)
    private String nombre;
    @OneToMany(mappedBy="pais")
    private List<Departamento> departamentos;
}
