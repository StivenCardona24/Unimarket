package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.DetalleVentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.DetalleVentaGetDTO;

import java.util.List;

public interface DetalleVentaServicio {


    int crearDetalleVenta(DetalleVentaDTO detalleVentaDTO) throws Exception;
    DetalleVentaGetDTO actualizarDetalleVenta(int codigoDetalleVenta, DetalleVentaDTO detalleVentaDTO) throws Exception;
    int eliminarDetalleVenta(int codigoDetalleVenta) throws Exception;

    DetalleVentaGetDTO obtenerDetalleVenta(int codigoDetalleVenta) throws Exception;
    List<DetalleVentaGetDTO>  obtenerDetalleVentaPorVenta(int idVenta) throws Exception;
    List<DetalleVentaGetDTO>  obtenerDetalleVentaProducto(int idProducto) throws Exception;

    List<DetalleVentaGetDTO>  findAllByProductoNombre(String nombre) throws Exception;

}
