package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.TokenDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoVenta;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.MetodoPago;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.VentaServicio;
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
public class VentaTest {

    @Autowired
    private VentaServicio ventaServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearVentaTest() {
        try {
            // se crea el usuario con el servicio de crear usuario
            TokenDTO.VentaDTO ventaDTO = new TokenDTO.VentaDTO(
                    1000000,
                    EstadoVenta.INACTIVE,
                    MetodoPago.EFECTIVO,
                    7998273,
                    1,
                    LocalDate.of(2023, 4, 17));




            int codigo = ventaServicio.crearVenta(ventaDTO);

            Venta venta = ventaServicio.obtener(codigo);


            System.out.println(venta.getCodigo());
            Assertions.assertNotEquals(7, venta.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        @Test
        @Sql("classpath:dataset.sql")
        public void listarComprasUsuarioTest() throws Exception {

            int idUsuario = 1;

            List<UsuarioGetDTO.VentaGetDTO> compras = ventaServicio.listarVentaUsuarios(idUsuario);

            Assertions.assertEquals(2, compras.size());
            Assertions.assertEquals(idUsuario, compras.get(0).getUsuario());
            Assertions.assertEquals(idUsuario, compras.get(1).getUsuario());
        }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCompraTest() throws Exception {

        int idCompra = 2;

        UsuarioGetDTO.VentaGetDTO venta = ventaServicio.obtenerVenta(idCompra);

        Assertions.assertEquals(idCompra, venta.getIdVenta());
        Assertions.assertEquals(MetodoPago.DAVIPLATA, venta.getMetodoPago());
    }



    }






