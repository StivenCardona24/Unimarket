package co.edu.uniquindio.proyecto.Modelo.Enumeraciones;

import lombok.*;

import java.io.Serializable;
@Getter
@NoArgsConstructor
@ToString
public enum MetodoPago implements Serializable{
    EFECTIVO,
    DAVIPLATA,
    NEQUI,
    TARJETA
}
