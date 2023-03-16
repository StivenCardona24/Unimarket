package co.edu.uniquindio.proyecto.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class VentaProducto {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    @Min(1)
    private int unidades;
    @NotNull
    private double precio;

    @OneToMany(mappedBy="ventaProducto")
    private List<Producto> productos;
    @ManyToOne
    private Venta venta;
}
