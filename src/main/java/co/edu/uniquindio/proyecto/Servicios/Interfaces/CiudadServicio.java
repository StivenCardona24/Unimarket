package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadGetDTO;

public interface CiudadServicio {

    int crearCiudad(CiudadDTO ciudadDTO)throws Exception;

    int actualizarCiudad(int codigoCiudad, CiudadDTO ciudadDTO) throws Exception;
    CiudadGetDTO obtenerCiudad(int codigoCiudad) throws Exception;
    CiudadGetDTO obtenerCiudadNombre(String nombre) throws Exception;

    int eliminarCiudad(int codigoCiudad) throws Exception;

}
