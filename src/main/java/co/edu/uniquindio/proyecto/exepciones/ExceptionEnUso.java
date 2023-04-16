package co.edu.uniquindio.proyecto.exepciones;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class ExceptionEnUso extends Throwable {

    public ExceptionEnUso(String s) {
        super(s);
    }
}
