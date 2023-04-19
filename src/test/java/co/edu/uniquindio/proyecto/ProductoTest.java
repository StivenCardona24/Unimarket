package co.edu.uniquindio.proyecto;


import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
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
public class ProductoTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearProducto() throws  Exception {

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(Categoria.TECNOLOGIA);

        Map<String, String> map = new HashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");

        int productoDTO = productoServicio.crearProducto(new ProductoDTO(
                "Xiaomi redmi mi11T Ultra",
                "Telefono inteligente",
                1,
                10,
                2350000,
                map,
                categorias
        ));

        System.out.println(productoDTO);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProducto() throws  Exception {

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(Categoria.TECNOLOGIA);

        Map<String, String> map = new HashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");

        ProductoGetDTO productoGetDTO = productoServicio.actualizarProducto(
                2,
                new ProductoDTO(
                        "Auriculares inalámbricos",
                        "Auriculares Xiaomi",
                        2,
                        10,
                        80000,
                        map,
                        categorias
                )
        );

        System.out.println(productoGetDTO.getCodigo() + productoGetDTO.getNombre());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUnidades() throws  Exception {

        ProductoGetDTO productoGetDTO = productoServicio.actualizarUnidades(1,30);

        System.out.println(productoGetDTO.getCodigo() + ' '+  productoGetDTO.getNombre() + " unidades:" + productoGetDTO.getUnidades());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEstado() throws  Exception {

        ProductoGetDTO productoGetDTO = productoServicio.actualizarEstado(1, EstadoProducto.EN_APROBACION);

        System.out.println(productoGetDTO.getCodigo() + ' '+  productoGetDTO.getNombre() + " ESTADO:" + productoGetDTO.getEstado());

    }
}
