package co.edu.uniquindio.proyecto.Modelo.DTO;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoVenta;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.MetodoPago;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioGetDTO {



    private Integer codigo;

 @NotNull(message = "el userName no puede ser nulo")
 @NotBlank(message = "el UserName no puede estar vacio")
 @Length(message = "no debe ser el UserName mas grande de 100 caracteres",max = 100)
    private String userName;



    @NotNull(message = "la cedula no deberia puede nula")
    @NotBlank(message = "la cedula no deberia epuedestar vacia")
    @Length(message = "no debe ser la cedula mas grande de 10 caracteres",max = 10)
    private String cedula;

    @NotNull(message = "El nombre no deberia puede nula")
    @NotBlank(message = "El nombre no deberia epuedestar vacia")
    @Length(message = "no debe ser el nombre mas grande de 100 caracteres",max = 100)
    private String nombre;

    @NotNull(message = "la direccion no deberia puede nula")
    @NotBlank(message = "la direccion no deberia epuedestar vacia")
    @Length(message = "no debe ser la direccion mas grande de 100 caracteres",max = 100)
    private String direccion;

    @NotNull(message = "El email no deberia puede nula")
    @NotBlank(message = "El email no deberia epuedestar vacia")
    @Length(message = "no debe ser el email mas grande de 10 caracteres",max = 100)
    private String email;

    @NotNull(message = "la telefono no deberia puede nula")
    @NotBlank(message = "la telefono no deberia epuedestar vacia")
    @Length(message = "no debe ser la telefono mas grande de 20 caracteres",max = 20)
    private String telefono;

   @NotNull(message = "la fechaNacimiento no deberia puede nula")
   @NotBlank(message = "la fechaNacimiento no deberia epuedestar vacia")
   @Length(message = "no debe ser la fechaNacimiento mas grande de 20 caracteres",max = 20)
   private LocalDate fechaNacimiento;

   private boolean activo;


}
