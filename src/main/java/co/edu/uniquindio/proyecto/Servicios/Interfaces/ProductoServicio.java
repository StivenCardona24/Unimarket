package co.edu.uniquindio.proyecto.Servicios.Interfaces;
import co.edu.uniquindio.proyecto.Modelo.Clases.Producto;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO)  throws Exception;

    ProductoGetDTO actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception;

    ProductoGetDTO actualizarUnidades(int codigoProducto, int unidades)  throws Exception;

    ProductoGetDTO actualizarEstado(int codigoProducto, EstadoProducto estado) throws Exception ; //Falta

    int eliminarProducto(int codigoProducto) throws Exception;

    Producto obtenerProducto(int codigo) throws Exception;

    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);

    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);

    List<ProductoGetDTO> listarProductosPorEstado(EstadoProducto estado);

    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);

    List<ProductoGetDTO> listarProductosNombre(String nombre);

    List<ProductoGetDTO> listarProductosPrecio(double precioMin, double precioMax);

    List<ProductoGetDTO> listarProductos();
}
