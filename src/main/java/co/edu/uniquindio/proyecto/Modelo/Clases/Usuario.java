package co.edu.uniquindio.proyecto.Modelo.Clases;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Role;
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
@Embeddable
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,length = 20)
    private String cedula;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 60)
    private String direccion;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(length = 16)
    private String telefono;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    private boolean activo;

    @ManyToOne
    private Ciudad ciudad;



    @Enumerated(EnumType.STRING)
    private Role enumRole;

    @ManyToOne
    private Licencia licencia;

    @ManyToMany(mappedBy="usuario")
    @ToString.Exclude
    private List<Tarjeta> tarjetas;
    @ManyToMany
    @ToString.Exclude
    private List<Producto> productoFavoritos;
    @OneToMany(mappedBy="usuarioPropietario")
    @ToString.Exclude
    private List<Producto> productosVender;
    @OneToMany(mappedBy="comentario")
    @ToString.Exclude
    private List<Comentario> comentarios;

}
