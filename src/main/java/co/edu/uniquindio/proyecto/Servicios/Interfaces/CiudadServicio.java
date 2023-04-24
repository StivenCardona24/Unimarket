package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadGetDTO;

import java.util.List;

public interface CiudadServicio {

    int crearCiudad(CiudadDTO ciudadDTO)throws Exception;

    CiudadGetDTO actualizarCiudad(int codigoCiudad, CiudadDTO ciudadDTO) throws Exception;
    int eliminarCiudad(int codigoCiudad) throws Exception;
    CiudadGetDTO obtenerCiudad(int codigoCiudad) throws Exception;
    List<CiudadGetDTO> obtenerCiudadNombre(String nombre) throws Exception;
    CiudadGetDTO obtenerCiudadNombreExacto(String nombre) throws Exception;

}
