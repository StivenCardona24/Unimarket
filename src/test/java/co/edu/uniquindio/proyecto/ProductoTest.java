package co.edu.uniquindio.proyecto;


import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
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
}
