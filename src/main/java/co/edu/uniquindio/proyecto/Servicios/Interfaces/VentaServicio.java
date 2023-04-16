package co.edu.uniquindio.proyecto.Servicios.Interfaces;


import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaGetDTO;

public interface VentaServicio {
    int crearVenta(VentaDTO ciudadDTO)throws Exception;

    int actualizarCiudad(int codigoCiudad, VentaDTO ciudadDTO) throws Exception;
    int eliminarCiudad(int codigoCiudad) throws Exception;
    VentaGetDTO obtenerCiudad(int codigoCiudad) throws Exception;
}
