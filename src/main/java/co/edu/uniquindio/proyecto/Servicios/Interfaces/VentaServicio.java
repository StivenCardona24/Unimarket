package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.DTO.ventaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ventaGetDTO;

import java.util.List;

public interface VentaServicio {


    int crearVenta(ventaDTO ventaDTO) throws Exception;

    List<ventaGetDTO> listarVentaUsuarios(int codigoVenta) throws Exception;

    ventaGetDTO obtenerVenta(int codigoVenta) throws Exception;

}
