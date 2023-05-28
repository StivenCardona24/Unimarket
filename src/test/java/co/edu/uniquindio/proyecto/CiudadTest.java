package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadGetDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CiudadServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest

public class CiudadTest {

    @Autowired
    private CiudadServicio ciudadServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCiudad() throws Exception {
        CiudadGetDTO ciudadObtenida=ciudadServicio.obtenerCiudad(1);
        Assertions.assertEquals( 1 , ciudadObtenida.getCodigo());
        Assertions.assertNotNull( ciudadObtenida);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCiudad() throws Exception {
        CiudadGetDTO ciudadObtenida=ciudadServicio.obtenerCiudad(1);
        CiudadDTO ciudadDTO =new CiudadDTO();
        ciudadDTO.setNombre("Bogotá3");
        Assertions.assertEquals( "Bogotá3" , ciudadServicio.actualizarCiudad(ciudadObtenida.getCodigo(),ciudadDTO).getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCiudad() throws Exception {
        CiudadDTO ciudadDTO =new CiudadDTO();
        ciudadDTO.setNombre("Armenia");
        int codigoCiudadCreada=ciudadServicio.crearCiudad(ciudadDTO);
        Assertions.assertEquals( "Armenia" , ciudadServicio.obtenerCiudad(codigoCiudadCreada).getNombre());
        Assertions.assertNotNull( codigoCiudadCreada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCiudad() throws Exception {
        CiudadGetDTO ciudadObtenida=ciudadServicio.obtenerCiudad(1);
       int ciudadEliminada= ciudadServicio.eliminarCiudad(1);
        Assertions.assertEquals( ciudadObtenida.getCodigo() , ciudadEliminada);
        Assertions.assertThrows(Exception.class, () -> ciudadServicio.eliminarCiudad(ciudadEliminada));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCiudadNombreExacto() throws Exception {
        CiudadGetDTO ciudadObtenida=ciudadServicio.obtenerCiudadNombreExacto("Cali");
        Assertions.assertEquals( 3 , ciudadObtenida.getCodigo());
        Assertions.assertEquals( "Cali" , ciudadObtenida.getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCiudadNombre() throws Exception {
        List<CiudadGetDTO> ciudadObtenida=ciudadServicio.obtenerCiudadNombre("Cal");
        Assertions.assertNotNull( ciudadObtenida);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCiudades() throws Exception {
        List<CiudadGetDTO> ciudadObtenida=ciudadServicio.obtenerCiudades();
        Assertions.assertNotNull( ciudadObtenida);
    }
}
