package co.edu.uniquindio.proyecto.Modelo.DTO;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DetalleVentaDTO {
    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 1, message = "La cantidad mínima es 1")
    @Max(value = 100, message = "La cantidad máxima es 100")
    private int unidades;

    @NotNull(message = "El precio de compra no puede ser nulo")
    @PositiveOrZero(message = "El precio de compra debe ser mayor o igual a cero")
    private double precioCompra;

    @NotNull(message = "El id del producto no puede ser nulo")
    private int idVenta;
    @NotNull(message = "El id del producto no puede ser nulo")
    private int idProducto;
}
