package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.DetalleVenta;
import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.DTO.*;
import co.edu.uniquindio.proyecto.Repositorios.TarjetaRepository;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepository;
import co.edu.uniquindio.proyecto.Repositorios.VentaRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.VentaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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


    @Override
    public int crearVenta( TokenDTO.VentaDTO ventaDTO) throws Exception{


        Venta nuevo = convertir(ventaDTO);

        Venta registro = ventaRepository.save(nuevo);

        double total = 0;

     /* for(DetalleVentaDTO ventaDTO1 : ventaDTO.getVentaProducto()){
            total += ventaDTO1.getPrecioCompra()*ventaDTO1.getUnidades();
        }
*/

        return registro.getCodigo();

    }

    @Override
    public List<UsuarioGetDTO.VentaGetDTO> listarVentaUsuarios(int codigoVenta) throws Exception {
        List<Venta> ventas  = ventaRepository.findByUsuarioIdUsuario(codigoVenta);
        List<UsuarioGetDTO.VentaGetDTO> VentaGetDTO = new ArrayList<>();

        for (Venta venta : ventas) {
            UsuarioGetDTO.VentaGetDTO dto = convertirDTO(venta);
            VentaGetDTO.add(dto);
        }

        return VentaGetDTO;
    }

    @Override
    public UsuarioGetDTO.VentaGetDTO obtenerVenta(int codigoVenta) throws Exception {

        return convertirDTO(obtener(codigoVenta));

    }

    @Override
    public Venta obtener(int codigoVenta) throws Exception {
        Optional<Venta> venta = ventaRepository.findById(codigoVenta);

        if (venta.isEmpty()) {
            throw new Exception("El código " + codigoVenta + " no está asociado a ningún venta");
        }

        return venta.get();
    }

    private Venta convertir(TokenDTO.VentaDTO ventaDTO) {

        Venta venta = new Venta();

        venta.setMetodoPago(ventaDTO.getMetodoPago());
        venta.setEstado(ventaDTO.getEstado());
        venta.setTotalCompra(ventaDTO.getTotalCompra());
        venta.setUsuario(usuarioRepository.findById(ventaDTO.getUsuario()).get());
      //  venta.setTajetaCompra(tarjetaRepository.findById(ventaDTO.getTajetaCompra()).get());
        venta.setFechaCompra(ventaDTO.getFechaCompra());
        return venta;
    }

    private UsuarioGetDTO.VentaGetDTO convertirDTO(Venta venta)  throws Exception {




        List<DetalleVentaDTO> detalleVntaDTOs = new ArrayList<>();
        if (venta.getVentaProducto() != null) { // Verificar si la lista es nula
            for (DetalleVenta ventaDTO1 : venta.getVentaProducto()) {

                DetalleVentaDTO detalle = new DetalleVentaDTO();
                detalle.setIdVenta(ventaDTO1.getVenta().getCodigo());
                detalle.setUnidades(ventaDTO1.getUnidades());
                detalle.setIdProducto(ventaDTO1.getProducto().getCodigo());

                detalleVntaDTOs.add(detalle);



            }
        }
        UsuarioGetDTO.VentaGetDTO ventaDTO = new UsuarioGetDTO.VentaGetDTO(
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
}
