package co.edu.uniquindio.proyecto;


import co.edu.uniquindio.proyecto.Modelo.DTO.EmailDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.EmailServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class EmailTest {
    @Autowired
    private EmailServicio emailServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void enviarCorreos() throws Exception {
        emailServicio.enviarEmail(new EmailDTO("Asunto", "Cuerpo mensaje", "proyectos.universidad.2023@gmail.com"));
    }
}
