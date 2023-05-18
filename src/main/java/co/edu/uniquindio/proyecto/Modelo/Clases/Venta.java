package co.edu.uniquindio.proyecto.Modelo.Clases;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoVenta;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.MetodoPago;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Venta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDate fechaCompra;
    @NotNull
    private double totalCompra;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoVenta estado;
    @NotNull
    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    @OneToMany(mappedBy="venta")
    @ToString.Exclude
    private List<DetalleVenta> detalleVentas;
    @ManyToOne
    private Tarjeta tajetaCompra;
    @ManyToOne
    private Usuario usuario;
   /* @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoObjeto estadoObjeto;*/
}
