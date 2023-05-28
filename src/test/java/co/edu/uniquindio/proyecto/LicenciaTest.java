package co.edu.uniquindio.proyecto;


import co.edu.uniquindio.proyecto.Modelo.DTO.LicenciaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.LicenciaGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.LicenciaServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Transactional
public class LicenciaTest {

    @Autowired
    private LicenciaServicio licenciaServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerLicencias() throws  Exception{
        List<LicenciaGetDTO> licencias = licenciaServicio.listarLicencias();

        for (LicenciaGetDTO l : licencias) {
            System.out.println(l.getNombre());
        }

        Assertions.assertEquals(5, licencias.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearLicencia() throws  Exception {

        int licencia = licenciaServicio.crearLicencia(new LicenciaDTO(
                "ORO ",
                50000,
                90,
                5
        ));

        System.out.println(licencia);

        Assertions.assertNotEquals(0, licencia);

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarLicencia() throws  Exception {

        LicenciaGetDTO licencia = licenciaServicio.actualizarLicencia(
                4,
                new LicenciaDTO(
                        "Licencia de Prueba",
                        0.0,
                        20,
                        1
                )
        );

        System.out.println(licencia.getCodigo() + licencia.getNombre());
        Assertions.assertEquals(20, licencia.getDiasActivoProducto());

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProducto() throws  Exception {

        LicenciaGetDTO licencia = licenciaServicio.obtenerLicencia(2);

        System.out.println(licencia.getNombre());

        Assertions.assertEquals(2, licencia.getCodigo());

    }



}
