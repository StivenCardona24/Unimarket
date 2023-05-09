package co.edu.uniquindio.proyecto;


import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class PasswordTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCodigo() throws Exception{
      int codigo =  usuarioServicio.generarCodigoContrasenia("proyectos.universidad.2023@gmail.com");

        Assertions.assertEquals(5, codigo);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void recuperarContrasenia() throws Exception{
        int codigo =  usuarioServicio.recuperarContrasenia("proyectos.universidad.2023@gmail.com", "un0irm39", "12345678");

        Assertions.assertEquals(5, codigo);
    }
}
