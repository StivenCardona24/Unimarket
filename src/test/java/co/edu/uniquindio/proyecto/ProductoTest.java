package co.edu.uniquindio.proyecto;


import co.edu.uniquindio.proyecto.Modelo.Clases.Producto;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
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
public class ProductoTest {

    @Autowired
    private ProductoServicio productoServicio;



    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductos() throws  Exception {

        List<ProductoGetDTO> productos = productoServicio.listarProductos();

        System.out.println(productos.size());
        for (ProductoGetDTO p: productos) {
            System.out.println( p.getNombre());

        }
        Assertions.assertEquals(6, productos.size());

    }

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

        Assertions.assertNotEquals(0, productoDTO);

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
        Assertions.assertEquals(80000, productoGetDTO.getPrecioUnitario());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUnidades() throws  Exception {

        ProductoGetDTO productoGetDTO = productoServicio.actualizarUnidades(1,30);

        System.out.println(productoGetDTO.getCodigo() + ' '+  productoGetDTO.getNombre() + " unidades:" + productoGetDTO.getUnidades());
        Assertions.assertEquals(30, productoGetDTO.getUnidades());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEstado() throws  Exception {

        ProductoGetDTO productoGetDTO = productoServicio.actualizarEstado(1, EstadoProducto.EN_APROBACION);


        System.out.println(productoGetDTO.getCodigo() + ' '+  productoGetDTO.getNombre() + " ESTADO:" + productoGetDTO.getEstado());
        Assertions.assertEquals(EstadoProducto.EN_APROBACION, productoGetDTO.getEstado());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarProducto() throws  Exception {

        int ward = productoServicio.eliminarProducto(1);

        System.out.println(ward);

        Assertions.assertEquals(1, ward);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProducto() throws  Exception {

        ProductoGetDTO producto = productoServicio.obtenerProducto(1);

        System.out.println(producto.getNombre());

        Assertions.assertEquals(1, producto.getCodigo());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductosUsuario() throws  Exception {

        List<ProductoGetDTO> productos = productoServicio.listarProductosUsuario(1);

        for (ProductoGetDTO p: productos) {
            System.out.println( p.getNombre() + p.getCodigoVendedor());
            Assertions.assertEquals(1, p.getCodigoVendedor());

        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductosCategoria() throws  Exception {
        crearProducto();
        List<ProductoGetDTO> productos = productoServicio.listarProductosCategoria(Categoria.TECNOLOGIA);

        System.out.println(productos.size());
        for (ProductoGetDTO p: productos) {
            System.out.println( p.getNombre() + p.getCategorias().contains(Categoria.TECNOLOGIA));

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductosEstado() throws  Exception {

        List<ProductoGetDTO> productos = productoServicio.listarProductosPorEstado(EstadoProducto.INACTIVE);

        System.out.println(productos.size());
        for (ProductoGetDTO p: productos) {
            System.out.println( p.getNombre() + p.getEstado());
            Assertions.assertEquals(EstadoProducto.INACTIVE, p.getEstado());

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductosFavoritos() throws  Exception {

        List<ProductoGetDTO> productos = productoServicio.listarProductosFavoritos(1);

        System.out.println(productos.size());
        for (ProductoGetDTO p: productos) {
            System.out.println( p.getNombre());


        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductosNombre() throws  Exception {

        List<ProductoGetDTO> productos = productoServicio.listarProductosNombre("Samsung");

        System.out.println(productos.size());
        for (ProductoGetDTO p: productos) {
            System.out.println( p.getNombre());
            Assertions.assertTrue(p.getNombre().contains("Samsung"));

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductosPrecio() throws  Exception {

        List<ProductoGetDTO> productos = productoServicio.listarProductosPrecio(200, 800);

        System.out.println(productos.size());
        for (ProductoGetDTO p: productos) {
            System.out.println( p.getNombre() + p.getPrecioUnitario());
            Assertions.assertTrue(p.getPrecioUnitario() >= 200 && p.getPrecioUnitario() <= 800);

        }
    }



}
