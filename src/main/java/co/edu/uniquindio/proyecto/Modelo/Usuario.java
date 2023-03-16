package co.edu.uniquindio.proyecto.Modelo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Usuario implements Serializable{
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false,length = 20)
    private String cedula;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 60)
    private String direccion;

    @Column(unique = true,nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(length = 16)
    private String telefono;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    private boolean activo;

    @ManyToOne
    private Ciudad ciudad;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Licencia licencia;

    @ManyToMany(mappedBy="usuarios")
    private List<Tarjeta> tarjetas;

    @OneToMany(mappedBy="usuario")
    private List<Producto> productos;
    @OneToMany(mappedBy="comentario")
    private List<Comentario> comentarios;

}
