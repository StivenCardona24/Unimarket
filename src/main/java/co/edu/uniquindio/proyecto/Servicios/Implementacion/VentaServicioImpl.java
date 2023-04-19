package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.DTO.DetalleVentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ventaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ventaGetDTO;
import co.edu.uniquindio.proyecto.Repositorios.VentaRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.VentaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VentaServicioImpl implements VentaServicio {


    private final VentaRepository ventaRepository;
    private  final UsuarioServicio usuario;


    @Override
    public int crearVenta(ventaDTO ventaDTO) throws Exception{


        Venta venta = new Venta();

        venta.setMetodoPago(ventaDTO.getMetodoPago());
        venta.setUsuario(usuario.obtener(ventaDTO.getUsuario().getCodigo()));

        double total = 0;

        for(DetalleVentaDTO ventaDTO1 : ventaDTO.getVentaProducto(){
            total += ventaDTO1.getPrecioCompra()*ventaDTO1.getCantidad();
        }


        return ventaRepository.save(venta).getCodigo();

    }

    @Override
    public List<ventaGetDTO> listarVentaUsuarios(int codigoVenta) throws Exception {
        return null;
    }

    @Override
    public ventaGetDTO obtenerVenta(int codigoVenta) throws Exception {
        return null;
    }

}
