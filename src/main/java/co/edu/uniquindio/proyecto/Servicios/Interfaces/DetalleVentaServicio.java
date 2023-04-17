package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.DetalleVentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.DetalleVentaGetDTO;

import java.util.List;

public interface DetalleVentaServicio {


    int crearDetalleVenta(DetalleVentaDTO detalleVentaDTO) throws Exception;

    int actualizarDetalleVenta(int codigoDetalleVenta, DetalleVentaDTO detalleVentaDTO) throws Exception;
    int eliminarComentario(int codigoDetalleVenta) throws Exception;
    DetalleVentaGetDTO obtenerDetalleVenta(int codigoDetalleVenta) throws Exception;
    List<ComentarioGetDTO>  obtenerDetalleVentaPorVenta(int idVenta) throws Exception;
    List<ComentarioGetDTO>  obtenerDetalleVentaConProducto(String texto) throws Exception;

}
