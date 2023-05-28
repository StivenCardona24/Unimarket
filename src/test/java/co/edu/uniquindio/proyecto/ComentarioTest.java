package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ComentarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Transactional
public class ComentarioTest {

    @Autowired
    private ComentarioServicio comentarioServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crearComentario() throws Exception{
        ComentarioDTO nuevoComentario =new ComentarioDTO("prueba Comentario",1,1);
        Integer comentarioCreado=comentarioServicio.crearComentario(nuevoComentario);
        Assertions.assertNotNull(comentarioCreado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosProducto() throws Exception{
        List<ComentarioGetDTO> listComentariosDTO=comentarioServicio.listarComentariosProducto(1);
        Assertions.assertNotNull(listComentariosDTO);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosUsuarioCedula() throws Exception{
        List<ComentarioGetDTO> listComentariosDTO=comentarioServicio.listarComentariosUsuarioCedula("12345678901");
        Assertions.assertNotNull(listComentariosDTO);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosUsuario() throws Exception{
        List<ComentarioGetDTO> listComentariosDTO=comentarioServicio.listarComentariosUsuario(1);
        Assertions.assertNotNull(listComentariosDTO);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariostexto() throws Exception{
        List<ComentarioGetDTO> listComentariosDTO=comentarioServicio.listarComentariostexto("Servicio");
        Assertions.assertNotNull(listComentariosDTO);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComentario() throws Exception{
        ComentarioGetDTO ComentariosDTO=comentarioServicio.obtenerComentario(1);
        Assertions.assertNotNull(ComentariosDTO);
        Assertions.assertEquals(1,ComentariosDTO.getIdComentario());

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void countComentarioProducto() throws Exception{
        Integer cantidadComentario=comentarioServicio.countComentarioProducto(1);
        Assertions.assertNotNull(cantidadComentario);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosFecha() throws Exception{
        List<ComentarioGetDTO> listComentariosDTO=comentarioServicio.listarComentariosFecha(LocalDate.parse("2022-03-05"));
        Assertions.assertNotNull(listComentariosDTO);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarComentario() throws Exception{
        ComentarioGetDTO getcomentario=comentarioServicio.obtenerComentario(1);
        ComentarioDTO nuevoComentario=new ComentarioDTO();
        nuevoComentario.setIdUsuario(getcomentario.getIdUsuario());
        nuevoComentario.setIdProducto(getcomentario.getIdProducto());
        nuevoComentario.setComentario("Texto nuevo practica");
        Assertions.assertEquals("Texto nuevo practica",comentarioServicio.actualizarComentario(1,nuevoComentario).getComentario());
       }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarComentario() throws Exception{
        Integer codigoEliminado=comentarioServicio.eliminarComentario(1);
        Assertions.assertNotNull(codigoEliminado);
        Assertions.assertThrows(Exception.class, () -> comentarioServicio.eliminarComentario(1));
    }

}
