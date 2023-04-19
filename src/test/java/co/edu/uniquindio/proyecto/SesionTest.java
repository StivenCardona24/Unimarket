package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.Modelo.DTO.SesionDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.TokenDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.SesionServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


@SpringBootTest
@Transactional
public class SesionTest {

    @Autowired
    private SesionServicio sesionServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void login() throws Exception {
        TokenDTO tokenDTO = sesionServicio.login(new SesionDTO(
                "usuario1@example.com",
                "1234"
        ));

        System.out.print(tokenDTO.getToken());
    }

}
