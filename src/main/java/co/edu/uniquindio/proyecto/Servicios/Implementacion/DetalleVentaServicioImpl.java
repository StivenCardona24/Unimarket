package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.Ciudad;
import co.edu.uniquindio.proyecto.Modelo.Clases.DetalleVenta;
import co.edu.uniquindio.proyecto.Modelo.Clases.Producto;
import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.DTO.DetalleVentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.DetalleVentaGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaGetDTO;
import co.edu.uniquindio.proyecto.Repositorios.DetalleVentaRepository;
import co.edu.uniquindio.proyecto.Repositorios.ProductoRepository;
import co.edu.uniquindio.proyecto.Repositorios.VentaRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CiudadServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.DetalleVentaServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.VentaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DetalleVentaServicioImpl implements DetalleVentaServicio {

    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;
    private final DetalleVentaRepository detalleVentaRepository;

    @Override
    public int crearDetalleVenta(DetalleVentaDTO detalleVentaDTO) throws Exception {
        if (detalleVentaDTO.getUnidades() < 1 || detalleVentaDTO.getUnidades() > 100) {
            throw new Exception("El Numero de unidades debe ser entre 1 y 100.");
        }
        if (detalleVentaDTO.getPrecioUnitario() < 0) {
            throw new Exception("El valor de la compra debe ser positivo.");
        }
        Optional<Venta> ventaExistente = ventaRepository.findById(detalleVentaDTO.getIdVenta());
        if (!ventaExistente.isPresent()) {
            throw new Exception("El codigo"+detalleVentaDTO.getIdVenta()+" de la venta no existe");
        }
        Optional<Producto> productoExitente = productoRepository.findById(detalleVentaDTO.getIdProducto());
        if (!productoExitente.isPresent()) {
            throw new Exception("El codigo"+detalleVentaDTO.getIdProducto()+" del producto no existe");
        }
        if(productoExitente.get().getUnidades()<detalleVentaDTO.getUnidades()){
            throw new Exception("del producto"+productoExitente.get().getNombre()+" no existen todas las unidades solicitadas " +
                    "existen"+detalleVentaDTO.getUnidades());
        }

        int CantidadProductos=productoExitente.get().getUnidades()-detalleVentaDTO.getUnidades();
        productoRepository.actualizarUnidades(productoExitente.get().getCodigo(),CantidadProductos);
        int codigo = detalleVentaRepository.save(convertirDTOToAnEntity(detalleVentaDTO)).getCodigo();

       updateVentaTotal(detalleVentaDTO.getIdVenta());
        return  codigo;
    }

    @Override
    public DetalleVentaGetDTO actualizarDetalleVenta(int codigoDetalleVenta, DetalleVentaDTO detalleVentaDTO) throws Exception {
        if (detalleVentaDTO.getUnidades() < 1 || detalleVentaDTO.getUnidades() > 100) {
            throw new Exception("El Numero de unidades debe ser entre 1 y 100.");
        }
        if (detalleVentaDTO.getPrecioUnitario() < 0) {
            throw new Exception("El valor de la compra debe ser positivo.");
        }
        Optional<Venta> ventaExistente = ventaRepository.findById(detalleVentaDTO.getIdVenta());
        if (!ventaExistente.isPresent()) {
            throw new Exception("El codigo"+detalleVentaDTO.getIdVenta()+" de la venta no existe");
        }
        Optional<Producto> productoExitente = productoRepository.findById(detalleVentaDTO.getIdProducto());
        if (!productoExitente.isPresent()) {
            throw new Exception("El codigo"+detalleVentaDTO.getIdProducto()+" del producto no existe");
        }
        DetalleVenta actualizarDetalleVenta=convertirDTOToAnEntity(detalleVentaDTO);
        actualizarDetalleVenta.setCodigo(codigoDetalleVenta);
        return convertirEntityToAnDTO(detalleVentaRepository.save(actualizarDetalleVenta));
    }

    @Override
    public int eliminarDetalleVenta(int codigoDetalleVenta) throws Exception {
        validarExistencia(codigoDetalleVenta);
        detalleVentaRepository.deleteById(codigoDetalleVenta);
        return codigoDetalleVenta;
    }

    @Override
    public DetalleVentaGetDTO obtenerDetalleVenta(int codigoDetalleVenta) throws Exception {
        Optional<DetalleVenta> detalleVentaActual=detalleVentaRepository.findById(codigoDetalleVenta);
        if (detalleVentaActual.isEmpty()) {
            throw new Exception("El código " + codigoDetalleVenta + " no está asociado a ningún producto");
        }
        return convertirEntityToAnDTO(detalleVentaActual.get());
    }

    @Override
    public List<DetalleVentaGetDTO> obtenerDetalleVentaPorVenta(int idVenta) throws Exception {
        List<DetalleVentaGetDTO> listDetalleVenta=new ArrayList<>();
        for(DetalleVenta detalleVentasRecorrer:detalleVentaRepository.findAllByVenta(idVenta)){
            DetalleVentaGetDTO nuevoDetalleVenta=convertirEntityToAnDTO(detalleVentasRecorrer);
            listDetalleVenta.add(nuevoDetalleVenta);
        }
        return listDetalleVenta;
    }

    @Override
    public List<DetalleVentaGetDTO> obtenerDetalleVentaProducto(int idProducto) throws Exception {
        List<DetalleVentaGetDTO> listDetalleVenta=new ArrayList<>();
        for(DetalleVenta detalleVentasRecorrer:detalleVentaRepository.findAllByProductoID(idProducto)){
            DetalleVentaGetDTO nuevoDetalleVenta=convertirEntityToAnDTO(detalleVentasRecorrer);
            listDetalleVenta.add(nuevoDetalleVenta);
        }
        return listDetalleVenta;
    }

    @Override
    public List<DetalleVentaGetDTO> findAllByProductoNombre(String nombre) throws Exception {
        List<DetalleVentaGetDTO> listDetalleVenta=new ArrayList<>();
        for(DetalleVenta detalleVentasRecorrer:detalleVentaRepository.findAllByProductoNombre(nombre)){
            DetalleVentaGetDTO nuevoDetalleVenta=convertirEntityToAnDTO(detalleVentasRecorrer);
            listDetalleVenta.add(nuevoDetalleVenta);
        }
        return listDetalleVenta;
    }


    private void validarExistencia(int codigo) throws Exception {
        boolean existe = detalleVentaRepository.existsById(codigo);
        if (!existe) {
            throw new Exception("El código: " + codigo + " no está asociado a ningún detalle Venta");
        }
    }
    public DetalleVentaGetDTO convertirEntityToAnDTO (DetalleVenta detalleVentaConvertir){
        DetalleVentaGetDTO nuevoDetalleVenta=new DetalleVentaGetDTO();
        nuevoDetalleVenta.setIdDetalleVenta(detalleVentaConvertir.getCodigo());
        nuevoDetalleVenta.setIdVenta(detalleVentaConvertir.getVenta().getCodigo());
        nuevoDetalleVenta.setUnidades(detalleVentaConvertir.getUnidades());
        nuevoDetalleVenta.setIdProducto(detalleVentaConvertir.getProducto().getCodigo());
        nuevoDetalleVenta.setPrecioUnitario(detalleVentaConvertir.getPrecioUnitario());
        return nuevoDetalleVenta;
    }
    public DetalleVenta convertirDTOToAnEntity (DetalleVentaDTO detalleVentaConvertir) throws Exception {
        DetalleVenta nuevodetalleVenta= new DetalleVenta();
        nuevodetalleVenta.setVenta(ventaRepository.findById(detalleVentaConvertir.getIdVenta()).get());
        nuevodetalleVenta.setPrecioUnitario(detalleVentaConvertir.getPrecioUnitario());
        nuevodetalleVenta.setUnidades(detalleVentaConvertir.getUnidades());
        nuevodetalleVenta.setProducto(productoRepository.findById(detalleVentaConvertir.getIdProducto()).get());
        return nuevodetalleVenta;
    }

    public void updateVentaTotal(int codigo) throws Exception{

        List<DetalleVentaGetDTO> listaProductos = obtenerDetalleVentaPorVenta(codigo);
        double total = 0;

        for (DetalleVentaGetDTO dv: listaProductos) {
            total += dv.getPrecioUnitario() * dv.getUnidades();
        }

        ventaRepository.actualizarTotal(codigo, total);

    }
}







