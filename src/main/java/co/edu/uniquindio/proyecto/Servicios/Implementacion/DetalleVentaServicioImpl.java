package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.DetalleVentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.DetalleVentaGetDTO;
import co.edu.uniquindio.proyecto.Repositorios.DetalleVentaRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.DetalleVentaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetalleVentaServicioImpl implements DetalleVentaServicio {
    private final DetalleVentaRepository detalleVentaRepository;
    @Override
    public int crearDetalleVenta(DetalleVentaDTO detalleVentaDTO) throws Exception {
        return 0;
    }

    @Override
    public int actualizarDetalleVenta(int codigoDetalleVenta, DetalleVentaDTO detalleVentaDTO) throws Exception {
        return 0;
    }

    @Override
    public int eliminarComentario(int codigoDetalleVenta) throws Exception {
        return 0;
    }

    @Override
    public DetalleVentaGetDTO obtenerDetalleVenta(int codigoDetalleVenta) throws Exception {
        return null;
    }

    @Override
    public List<ComentarioGetDTO> obtenerDetalleVentaPorVenta(int idVenta) throws Exception {
        return null;
    }

    @Override
    public List<ComentarioGetDTO> obtenerDetalleVentaConProducto(String texto) throws Exception {
        return null;
    }
}
