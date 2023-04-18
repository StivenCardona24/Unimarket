package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import co.edu.uniquindio.proyecto.exepciones.ExceptionEnUso;
import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.util.ClassPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

@SpringBootTest
@Transactional
public class UsuarioTest {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerUsuarioTest() throws Exception {
        // Para obtener el usuario se debe crear primero

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Usuario1",
                "1234",
                "12300007",
                "juan23",
                "cr24 cll32",
                "juan2h45623eqweqwgh@gmail",
                "1234",
                LocalDate.of(2023, 4, 17),
                true);

        int codigo = usuarioServicio.crearUsuario(usuarioDTO);

        Usuario usuario = usuarioServicio.obtener(codigo);
        /*
        Comprobamos que la dirección que está en la base de datos coincide con la
        que esperamos
         */
        Assertions.assertEquals("cr24 cll32", usuario.getDireccion());

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void crearUsuarioTest() {
        try {


            // se crea el usuario con el servicio de crear usuario
            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    "Usuario1",
                    "1234",
                    "12300007",
                    "juan23",
                    "cr24 cll32",
                    "juan2h45623eqweqwgh@gmail",
                    "1234",
                    LocalDate.of(2023, 4, 17),
                    true);

            int codigo = usuarioServicio.crearUsuario(usuarioDTO);

            Usuario usuario = usuarioServicio.obtener(codigo);


            System.out.println(usuario.getNombre());
            Assertions.assertNotEquals(0, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarUsuario() throws Exception {


        int usuarioEliminado = usuarioServicio.eliminarUsuario(1);

        Assertions.assertThrows(Exception.class, () -> usuarioServicio.obtenerUsuario(usuarioEliminado));


    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUsuarioTest() {

        try {



            // Crear un objeto de tipo usuarioDTO con los datos a modificar
            UsuarioDTO usuarioActualizado = new UsuarioDTO();
            usuarioActualizado.setNombre("juan");

            UsuarioGetDTO usuarioActualizadoResult = usuarioServicio.actualizarUsuario(2, usuarioActualizado);

            // Verifica que el usuario fue eliminado

        //    Assertions.assertEquals("juan", usuarioActualizadoResult.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


     /**
     @Test public void methodimplement(){

     claseDTO test= new contrcuto();
     usuarioServicio.metodoprueba();



     UsuarioDTO usuarioDTO = new UsuarioDTO();
     Assertions.assertEquals("experado","dado");








     } **/

}
