package co.edu.uniquindio.proyecto.Modelo.Clases;
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
//@EmbeddedId
//@ElementCollection
public class Role implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 30)
    private String nombre;
    @OneToMany(mappedBy="role")
    @ToString.Exclude
    private List<Usuario> usuarios;
}
