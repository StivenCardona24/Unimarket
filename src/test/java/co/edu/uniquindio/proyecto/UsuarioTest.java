package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
@Transactional
public class UsuarioTest {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Test
    public void methodimplement(){
        /**
        claseDTO test= new contrcuto();
        usuarioServicio.metodoprueba();
         **/
        Assertions.assertEquals("experado","dado");
    }
}
