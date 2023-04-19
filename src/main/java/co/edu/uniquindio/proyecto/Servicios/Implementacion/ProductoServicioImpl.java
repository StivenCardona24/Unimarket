package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.Producto;
import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import co.edu.uniquindio.proyecto.Repositorios.ProductoRepository;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Usuario vendedor = usuarioRepository.findUsuariosByCodigo(productoDTO.getVendedor());

        if(vendedor == null ){
            throw new Exception("El vendedor no existe");
        }

        Optional<Producto> buscar = productoRepository.buscarProductoPorNombreYVendedor(productoDTO.getNombre(), productoDTO.getVendedor());
        if(buscar.isPresent()){
            throw new Exception("Este producto ya lo contiene el vendedor");
        }

        Producto nuevo = convertir(productoDTO, vendedor);
        Producto registro = productoRepository.save(nuevo);
        return registro.getCodigo();
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) {
        return 0;
    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) {
        return 0;
    }

    @Override
    public int actualizarEstado(int codigoProducto, EstadoProducto estado) {
        return 0;
    }

    @Override
    public int eliminarProducto(int codigoProducto) {
        return 0;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(EstadoProducto estado) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(double precioMin, double precioMax) {
        return null;
    }


    //crear metodo de conversion de entity a DTO

    private Producto convertir(ProductoDTO productoDTO, Usuario vendedor) {

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecioUnitario(productoDTO.getPrecio());

        //Fecha quemada
        producto.setFechaLimite( LocalDate.now().plusMonths(1));

        EstadoProducto estado = EstadoProducto.INACTIVE;
        producto.setEstado(estado);
        producto.setUsuarioPropietario(vendedor);
        producto.setCategorias(productoDTO.getCategorias());
        producto.setImagenes(productoDTO.getImagenes());

        return producto;
    }
}
