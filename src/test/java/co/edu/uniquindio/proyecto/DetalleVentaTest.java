package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.Modelo.DTO.DetalleVentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.DetalleVentaGetDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.DetalleVentaServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class DetalleVentaTest {
    @Autowired
    private DetalleVentaServicio detalleVentaServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearDetalleVenta() throws Exception {
        DetalleVentaDTO nuevoDetalleVenta= new DetalleVentaDTO();
        nuevoDetalleVenta.setIdVenta(2);
        nuevoDetalleVenta.setIdProducto(1);
        nuevoDetalleVenta.setPrecioCompra(400000);
        nuevoDetalleVenta.setUnidades(5);
        Assertions.assertNotNull(detalleVentaServicio.crearDetalleVenta(nuevoDetalleVenta));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarDetalleVenta() throws Exception {
        DetalleVentaGetDTO detalleVentaObtenido=detalleVentaServicio.obtenerDetalleVenta(1);
        DetalleVentaDTO detalleVentaDTO =new DetalleVentaDTO(5,1000,2,1);
        Assertions.assertNotNull(detalleVentaServicio.actualizarDetalleVenta(detalleVentaObtenido.getIdDetalleVenta(),detalleVentaDTO));
        Assertions.assertEquals(1000,detalleVentaServicio.actualizarDetalleVenta(detalleVentaObtenido.getIdDetalleVenta(),detalleVentaDTO).getPrecioCompra());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarDetalleVenta() throws Exception {
        DetalleVentaGetDTO detalleVentaObtenido=detalleVentaServicio.obtenerDetalleVenta(1);
        int detalleEliminado=detalleVentaServicio.eliminarDetalleVenta(detalleVentaObtenido.getIdDetalleVenta());
        Assertions.assertEquals(1,detalleEliminado);
        Assertions.assertThrows(Exception.class, () -> detalleVentaServicio.eliminarDetalleVenta(detalleVentaObtenido.getIdDetalleVenta()));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerDetalleVenta() throws Exception {
        DetalleVentaGetDTO detalleVentaObtenido=detalleVentaServicio.obtenerDetalleVenta(1);
        Assertions.assertEquals( 1 , detalleVentaObtenido.getIdDetalleVenta());
        Assertions.assertNotNull( detalleVentaObtenido);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerDetalleVentaPorVenta() throws Exception {
        DetalleVentaGetDTO detalleVentaObtenido=detalleVentaServicio.obtenerDetalleVenta(1);
        List<DetalleVentaGetDTO> listaDetalleVenta=detalleVentaServicio.obtenerDetalleVentaPorVenta(detalleVentaObtenido.getIdVenta());
        Assertions.assertNotNull( listaDetalleVenta);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void findAllByProductoNombre() throws Exception {
        List<DetalleVentaGetDTO> listaDetalleVenta=detalleVentaServicio.findAllByProductoNombre("a");
        Assertions.assertNotNull( listaDetalleVenta);
    }

}
