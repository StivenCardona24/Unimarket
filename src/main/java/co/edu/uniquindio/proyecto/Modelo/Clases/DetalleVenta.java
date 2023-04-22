package co.edu.uniquindio.proyecto.Modelo.Clases;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class DetalleVenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    @Min(1)
    @ToString.Exclude
    private int unidades;
    @NotNull
    @ToString.Exclude
    private double precio;

    @ManyToOne
    @ToString.Exclude
    private Producto producto;
    @ManyToOne
    @ToString.Exclude
    private Venta venta;
}
