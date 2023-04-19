package co.edu.uniquindio.proyecto.Servicios.Interfaces;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO);

    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO);

    int actualizarUnidades(int codigoProducto, int unidades);

    int actualizarEstado(int codigoProducto, EstadoProducto estado);

    int eliminarProducto(int codigoProducto);

    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);

    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);

    List<ProductoGetDTO> listarProductosPorEstado(EstadoProducto estado);

    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);

    List<ProductoGetDTO> listarProductosNombre(String nombre);

    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);
}
