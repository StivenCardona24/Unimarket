package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.TokenDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoVenta;


import java.util.List;

public interface VentaServicio {



    int crearVenta(VentaDTO ventaDTO) throws Exception;

    List<VentaGetDTO> listarVentaUsuarios(int codigoVenta) throws Exception;

    VentaGetDTO obtenerVenta(int codigoVenta) throws Exception;

    Venta obtener (int codigoVenta)throws Exception;

    VentaGetDTO actualizarEstado(int codigo, EstadoVenta estado) throws Exception;

    Double ventasMesAnio(int mes, int anio) throws Exception;

}
