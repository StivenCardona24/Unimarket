package co.edu.uniquindio.proyecto.Modelo;

import lombok.*;

import java.io.Serializable;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum MetodoPago implements Serializable{
    EFECTIVO,
    DAVIPLATA,
    NEQUI,
    TARJETA
}
