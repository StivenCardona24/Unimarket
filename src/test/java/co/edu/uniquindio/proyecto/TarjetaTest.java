package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.Modelo.DTO.*;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoTarjeta;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.TipoTarjeta;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CiudadServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.TarjetaServicio;
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
public class TarjetaTest {


    @Autowired
    private TarjetaServicio tarjetaServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearTarjeta() throws Exception {
        TarjetaDTO TarjetaDto =new TarjetaDTO();
        TarjetaDto.setNombre("tarjeta1");
        TarjetaDto.setCVV("944");
        TarjetaDto.setNumero("526557001941");
        TarjetaDto.setDinero(22222);
        TarjetaDto.setFecha(   LocalDate.of(2023, 4, 17));
        TarjetaDto.setEstado(EstadoTarjeta.ACTIVA);
        TarjetaDto.setTipo(TipoTarjeta.CREDITO);


        int codigoTaejetaCreada=tarjetaServicio.crearTarjeta(TarjetaDto);
        Assertions.assertEquals( "tarjeta1" , tarjetaServicio.obtenerTarjeta(codigoTaejetaCreada).getNombre());
        Assertions.assertNotNull( codigoTaejetaCreada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerTarjeta() throws Exception {
        TarjetaGetDto tarjetaObtenida=tarjetaServicio.obtenerTarjeta(1);
        Assertions.assertEquals( 1 , tarjetaObtenida.getCodigo());
        Assertions.assertNotNull( tarjetaObtenida);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTarjeta() throws Exception {


        int terjetaEliminado = tarjetaServicio.eliminarTarjeta(1);

        Assertions.assertThrows(Exception.class, () -> tarjetaServicio.obtenerTarjeta(terjetaEliminado));


    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarTarjetaTest() {

        try {



            // Crear un objeto de tipo TarjetaDTO con los datos a modificar
            TarjetaDTO tatjetaActualizada = new TarjetaDTO();
            tatjetaActualizada.setNombre("tarjeta1");

            TarjetaGetDto tarjetaActualizadoResult = tarjetaServicio.actualizarTarjeta(2, tatjetaActualizada);

            // Verifica que el Tarjeta fue eliminado

            Assertions.assertEquals("tarjeta1", tarjetaActualizadoResult.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTarjetasUsuarioTest() throws Exception {
        List<TarjetaGetDto> listTarjetasDTO=tarjetaServicio.obtenerTarjetaUsuario(1);
        Assertions.assertNotNull(listTarjetasDTO);

        System.out.println(listTarjetasDTO.get(0).getNumero());



      //  int idUsuario = 1;

        //List<TarjetaGetDto> tarjetas = tarjetaServicio.obtenerTarjetaUsuario(idUsuario);

     //   Assertions.assertEquals(2, tarjetas.size());
      //  Assertions.assertEquals(idUsuario, tarjetas.get(0).getUsuario());
      //  Assertions.assertEquals(idUsuario, tarjetas.get(1).getUsuario());
    }


}
