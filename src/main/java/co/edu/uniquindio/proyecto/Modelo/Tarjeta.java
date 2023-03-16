package co.edu.uniquindio.proyecto.Modelo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
public class Tarjeta implements Serializable{

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    //@EmbeddedId
    private int codigo;
    @Column(nullable = false, length = 30)
    private String nombre;
    @Column(nullable = false)
    private String numero;
    @NotNull
    private LocalDate fecha;
    @Column(nullable = false)
    private double dinero;
    @Column(nullable = false,length = 4)
    private String CVV;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoTarjeta estado;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTarjeta tipo;
    @ManyToMany
    private List<Usuario> usuarios;

}
