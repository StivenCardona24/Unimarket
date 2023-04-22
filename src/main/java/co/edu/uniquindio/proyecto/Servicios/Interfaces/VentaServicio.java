package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.TokenDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;


import java.util.List;

public interface VentaServicio {



    int crearVenta(TokenDTO.VentaDTO ventaDTO) throws Exception;

    List<UsuarioGetDTO.VentaGetDTO> listarVentaUsuarios(int codigoVenta) throws Exception;

    UsuarioGetDTO.VentaGetDTO obtenerVenta(int codigoVenta) throws Exception;

    Venta obtener (int codigoVenta)throws Exception;

}
