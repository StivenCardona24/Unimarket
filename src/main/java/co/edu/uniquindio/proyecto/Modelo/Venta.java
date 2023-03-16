package co.edu.uniquindio.proyecto.Modelo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Venta implements Serializable{
    @Id
    @GeneratedValue
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
    private List<VentaProducto> ventaProducto;
}
