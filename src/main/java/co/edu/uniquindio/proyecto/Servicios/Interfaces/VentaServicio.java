package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.DTO.ventaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ventaGetDTO;

import java.util.List;

public interface VentaServicio {


    int crearCompra(ventaDTO ventaDTO) throws Exception;

    List<ventaGetDTO> listarComprasUsuarios(int codigoVenta) throws Exception;

    ventaGetDTO obtenerCompra(int codigoVenta) throws Exception;

}
