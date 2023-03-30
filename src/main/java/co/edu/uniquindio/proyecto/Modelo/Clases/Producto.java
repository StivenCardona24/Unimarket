package co.edu.uniquindio.proyecto.Modelo.Clases;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Embeddable
public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(nullable = false)
    @Min(1)
    private int unidades;

    @Column(length = 50)
    private String nombre;
    @Lob
    private Long descripcion;

    @Column(nullable = false)
    @Min(1)
    private double precioUnitario;

    private boolean disponibilidad;
    @Column(nullable = false)
    private LocalDate fechaLimite;
    @ElementCollection
    @NotNull
    private Map<String,String> imagenes;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoProducto estado;
    @ElementCollection
    @NotNull
    @Enumerated(EnumType.STRING)
    private List<Categoria> categorias;
    @OneToMany(mappedBy="comentario")
    @ToString.Exclude
    private List<Comentario> comentarios;
    @ManyToOne
    private Usuario usuarioPropietario;
    @ManyToOne
    private DetalleVenta ventaProducto;

    @ManyToMany(mappedBy="productoFavoritos")
    @ToString.Exclude
    private List<Usuario> favoritoUsuarios;



}
