package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaGetDTO;


import java.util.List;

public interface VentaServicio {



    int crearVenta(VentaDTO ventaDTO) throws Exception;

    List<VentaGetDTO> listarVentaUsuarios(int codigoVenta) throws Exception;

    VentaGetDTO obtenerVenta(int codigoVenta) throws Exception;

    Venta obtener (int codigoVenta)throws Exception;

}
