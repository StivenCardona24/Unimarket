package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.DetalleVenta;
import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.DTO.*;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoVenta;
import co.edu.uniquindio.proyecto.Repositorios.TarjetaRepository;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepository;
import co.edu.uniquindio.proyecto.Repositorios.VentaRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.EmailServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.VentaServicio;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VentaServicioImpl implements VentaServicio {

    private final DetalleVentaServicioImpl detalleVentaServicioImpl;
    private final TarjetaRepository tarjetaRepository;
    private final UsuarioRepository usuarioRepository;

    private final VentaRepository ventaRepository;
    private  final UsuarioServicio usuario;

    private  final EmailServicio emailServicio;
    @Override

    public int crearVenta(VentaDTO ventaDTO) throws Exception{
        Venta nuevo = convertir(ventaDTO);
        nuevo.setEstadoObjeto(EstadoObjeto.ACTIVE);
        Venta registro = ventaRepository.save(nuevo);
        emailServicio.enviarEmail(new EmailDTO("Compra", "Se realizo una compra del usuario " +ventaDTO.getUsuario() , "usuario1@example.com"));
        return registro.getCodigo();
    }

    @Override
    public List<VentaGetDTO> listarVentaUsuarios(int codigoVenta) throws Exception {
        List<Venta> ventas  = ventaRepository.findByUsuarioIdUsuario(codigoVenta);
        List<VentaGetDTO> VentaGetDTO = new ArrayList<>();
        for (Venta venta : ventas) {
            VentaGetDTO dto = convertirDTO(venta);
            VentaGetDTO.add(dto);
        }
        return VentaGetDTO;
    }

    @Override
    public VentaGetDTO obtenerVenta(int codigoVenta) throws Exception {
        return convertirDTO(obtener(codigoVenta));
    }


    @Override
    @Transactional
    public Venta obtener(int codigoVenta) throws Exception {
        Optional<Venta> venta = ventaRepository.findById(codigoVenta);
        if (venta.isEmpty()) {
            throw new Exception("El código " + codigoVenta + " no está asociado a ningún venta");
        }
        return venta.get();
    }

    @Override
    public VentaGetDTO actualizarEstado(int codigo, EstadoVenta estadoVenta) throws Exception{
        validarExiste(codigo);
        if(estadoVenta == EstadoVenta.PAGADO){
            ventaRepository.actualizarFecha(codigo, LocalDate.now());
        }
        ventaRepository.actualizarEstado(codigo, estadoVenta);
        return obtenerVenta(codigo);
    }

    @Override
    public int eliminarVenta(int codigoVenta) throws Exception {
        validarExiste(codigoVenta);
        ventaRepository.actualizarEstadoObjeto(codigoVenta,EstadoObjeto.INACTIVE);
        return codigoVenta;
    }

    private Venta convertir(VentaDTO ventaDTO) {
        Venta venta = new Venta();
        venta.setMetodoPago(ventaDTO.getMetodoPago());
        venta.setEstado(ventaDTO.getEstado());
        venta.setTotalCompra(ventaDTO.getTotalCompra());
        venta.setUsuario(usuarioRepository.findById(ventaDTO.getUsuario()).get());
        venta.setFechaCompra(ventaDTO.getFechaCompra());
        return venta;
    }

    private VentaGetDTO convertirDTO(Venta venta)  throws Exception {
        List<DetalleVentaDTO> detalleVntaDTOs = new ArrayList<>();
        if (venta.getDetalleVentas() != null) { // Verificar si la lista es nula
            for (DetalleVenta ventaDTO1 : venta.getDetalleVentas()) {
                DetalleVentaDTO detalle = new DetalleVentaDTO();
                detalle.setIdVenta(ventaDTO1.getVenta().getCodigo());
                detalle.setUnidades(ventaDTO1.getUnidades());
                detalle.setIdProducto(ventaDTO1.getProducto().getCodigo());
                detalleVntaDTOs.add(detalle);
            }
        }
        System.out.println(venta.getCodigo());
        VentaGetDTO ventaDTO = new VentaGetDTO(
                venta.getCodigo(),
                venta.getFechaCompra(),
                venta.getTotalCompra(),
                venta.getEstado(),
                venta.getMetodoPago(),
                venta.getTajetaCompra().getCodigo(),
                venta.getUsuario().getCodigo(),detalleVntaDTOs
                 );
        return ventaDTO;
    }

    private void validarExiste(int codigo) throws Exception {
        boolean existe = ventaRepository.existsById(Integer.valueOf(codigo));
        boolean existe2 = ventaRepository.findVentaIdActivo(codigo);
        if (!existe) {
            throw new Exception("El código " + codigo + " no está asociado a ningúna venta");
        }
        if (!existe2) {
            throw new Exception("El código " + codigo + " Se encuentra inactivo");
        }
    }

}
