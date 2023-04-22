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

    @Column(length = 50)
    private String nombre;

    @Lob
    private String descripcion;

    @Column(nullable = false)
    @Min(0)
    private int unidades;

    @Column(nullable = false)
    @Min(1)
    private double precioUnitario;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoProducto estado;

    @Column(nullable = false)
    private LocalDate fechaLimite;

    private  boolean disponible;
    @ElementCollection
    @NotNull
    private Map<String,String> imagenes;

    //verificar si es necesario que un producto tenga varias categorias
    @ElementCollection
    @NotNull
    @Enumerated(EnumType.STRING)
    private List<Categoria> categorias;
    @OneToMany(mappedBy="comentario")
    @ToString.Exclude
    private List<Comentario> comentarios;
    @OneToMany(mappedBy="producto")
    @ToString.Exclude
    private List<DetalleVenta> detalleVentas;
    @ManyToOne
    private Usuario usuarioPropietario;

    @OneToMany(mappedBy="producto")
    @ToString.Exclude
    private List<DetalleVenta> detalleVentaProducto;
    @ManyToMany(mappedBy="productoFavoritos")
    @ToString.Exclude
    private List<Usuario> favoritoUsuarios;



}
