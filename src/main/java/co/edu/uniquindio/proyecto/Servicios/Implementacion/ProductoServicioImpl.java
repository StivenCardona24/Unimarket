package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.Producto;
import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import co.edu.uniquindio.proyecto.Repositorios.ProductoRepository;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<ProductoGetDTO> listarProductos(){

        List<Producto> productos = productoRepository.findAll();
        List<ProductoGetDTO> productosGetDTOS = new ArrayList<>();
        for (Producto p: productos) {

            //System.out.println(p.getNombre());
            ProductoGetDTO pro = convertirDTO(p);
            productosGetDTOS.add(pro);


        }
        return productosGetDTOS;
    }

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Usuario vendedor = usuarioRepository.findUsuariosByCodigo(productoDTO.getVendedor());

        if(vendedor == null ){
            throw new Exception("El usuario no existe");
        }

        Optional<Producto> buscar = productoRepository.buscarProductoPorNombreYVendedor(productoDTO.getNombre(), productoDTO.getVendedor());
        if(buscar.isPresent()){
            throw new Exception("Este producto ya lo contiene el vendedor");
        }


        Producto nuevo = convertir(productoDTO, vendedor);

        //Datos quemados
        nuevo.setFechaLimite( LocalDate.now().plusDays(vendedor.getLicencia().getDiasActivoProducto()));
        EstadoProducto estado = EstadoProducto.INACTIVE;
        nuevo.setEstado(estado);
        nuevo.setDisponible(true);

        Producto registro = productoRepository.save(nuevo);
        return registro.getCodigo();
    }

    @Override
    public ProductoGetDTO actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception {

        Usuario vendedor = usuarioRepository.findUsuariosByCodigo(productoDTO.getVendedor());

        if(vendedor == null ){
            throw new Exception("El usuario no existe");
        }

        validarExiste(codigoProducto);
        Optional<Producto> actual = productoRepository.findById(codigoProducto);

        Producto producto = convertir(productoDTO, vendedor);
        //DATOS
        producto.setFechaLimite( actual.get().getFechaLimite());
        EstadoProducto estado = actual.get().getEstado();
        producto.setEstado(estado);
        producto.setDisponible(true);
        producto.setCodigo(codigoProducto);




        return convertirDTO(productoRepository.save(producto));
    }

    @Override
    public ProductoGetDTO actualizarUnidades(int codigoProducto, int unidades) throws Exception {

        validarExiste(codigoProducto);
        productoRepository.actualizarUnidades(codigoProducto, unidades);
       return  obtenerProducto(codigoProducto);
    }

    @Override
    public ProductoGetDTO actualizarEstado(int codigoProducto, EstadoProducto estado) throws Exception {
        validarExiste(codigoProducto);
        productoRepository.actualizarEstado(codigoProducto, estado);
        return obtenerProducto(codigoProducto);
    }

    @Override
    public int eliminarProducto(int codigoProducto) throws Exception {
        validarExiste(codigoProducto);
        productoRepository.deleteByCodigo(codigoProducto);
        Optional<Producto> producto = productoRepository.findById(codigoProducto);
        if (producto.orElse(null) != null && producto.get().isDisponible()){
            return 0;
        }
        return 1;

    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigo) throws Exception {
        Optional<Producto> producto = productoRepository.findById(codigo);
        ProductoGetDTO productoGetDTO = convertirDTO(producto.get());
        return productoGetDTO;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) throws Exception {
        Usuario vendedor = usuarioRepository.findUsuariosByCodigo(codigoUsuario);

        if(vendedor == null ){
            throw new Exception("El Usuario no existe");
        }

        List<Producto> productos = productoRepository.listarProductosPropietario(codigoUsuario);

        List<ProductoGetDTO> productosGetDTOS = new ArrayList<>();
        for (Producto p: productos) {

            //System.out.println(p.getNombre());
            ProductoGetDTO pro = convertirDTO(p);
            productosGetDTOS.add(pro);


        }

        return productosGetDTOS;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {

        List<Producto> productos = productoRepository.findProductoByCategoriasAndDisponible(categoria);
        List<ProductoGetDTO> productosGetDTOS = new ArrayList<>();
        for (Producto p: productos) {

            //System.out.println(p.getNombre());
            ProductoGetDTO pro = convertirDTO(p);
            productosGetDTOS.add(pro);


        }
        return productosGetDTOS;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(EstadoProducto estado) {

        List<Producto> productos = productoRepository.findProductoByEstado(estado);
        List<ProductoGetDTO> productosGetDTOS = new ArrayList<>();
        for (Producto p: productos) {

            //System.out.println(p.getNombre());
            ProductoGetDTO pro = convertirDTO(p);
            productosGetDTOS.add(pro);


        }
        return productosGetDTOS;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) {
        List<Producto> productos = productoRepository.findProductoByFavoritoUsuarios(codigoUsuario);
        List<ProductoGetDTO> productosGetDTOS = new ArrayList<>();
        for (Producto p: productos) {

            //System.out.println(p.getNombre());
            ProductoGetDTO pro = convertirDTO(p);
            productosGetDTOS.add(pro);


        }
        return productosGetDTOS;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) {

        List<Producto> productos = productoRepository.findProductoByNombre(nombre.toLowerCase());
        List<ProductoGetDTO> productosGetDTOS = new ArrayList<>();
        for (Producto p: productos) {

            //System.out.println(p.getNombre());
            ProductoGetDTO pro = convertirDTO(p);
            productosGetDTOS.add(pro);


        }
        return productosGetDTOS;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(double precioMin, double precioMax) {
        List<Producto> productos = productoRepository.findProductoByPrecioUnitario(precioMin, precioMax);
        List<ProductoGetDTO> productosGetDTOS = new ArrayList<>();
        for (Producto p: productos) {

            //System.out.println(p.getNombre());
            ProductoGetDTO pro = convertirDTO(p);
            productosGetDTOS.add(pro);


        }
        return productosGetDTOS;
    }


    //crear metodo de conversion de entity a DTO

    private Producto convertir(ProductoDTO productoDTO, Usuario vendedor) {

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecioUnitario(productoDTO.getPrecio());
        producto.setUsuarioPropietario(vendedor);
        producto.setCategorias(productoDTO.getCategorias());
        producto.setImagenes(productoDTO.getImagenes());

        return producto;
    }

    private ProductoGetDTO convertirDTO(Producto producto) {

        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getCodigo(),
                producto.getEstado(),
                producto.getFechaLimite(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getUnidades(),
                producto.getPrecioUnitario(),
                producto.getUsuarioPropietario().getCodigo(),
                producto.getImagenes(),
                producto.getCategorias()

        );


        return productoGetDTO;
    }

    private void validarExiste(int codigo) throws Exception {
        boolean existe = productoRepository.existsById(Integer.valueOf(codigo));

        if (!existe) {
            throw new Exception("El código " + codigo + " no está asociado a ningún producto");
        }

    }

}


