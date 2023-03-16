package co.edu.uniquindio.proyecto.Modelo;

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
