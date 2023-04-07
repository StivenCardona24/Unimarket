package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.util.ClassPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class UsuarioTest {
    @Autowired
    private UsuarioServicio usuarioServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarUsuario() throws Exception {


        int usuarioEliminado = usuarioServicio.eliminarUsuario(1);

        Assertions.assertThrows(Exception.class, () -> usuarioServicio.obtenerUsuario(usuarioEliminado));


    }


    /**
     @Test public void methodimplement(){

     claseDTO test= new contrcuto();
     usuarioServicio.metodoprueba();



     UsuarioDTO usuarioDTO = new UsuarioDTO();
     Assertions.assertEquals("experado","dado");








     } **/

}
