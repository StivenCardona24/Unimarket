package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadGetDTO;

public interface CiudadServicio {

    int crearCiudad(CiudadDTO ciudadDTO);

    int actualizarCiudad(int codigoCiudad, CiudadDTO ciudadDTO);
    CiudadGetDTO obtenerCiudad(int codigoCiudad);

    int eliminarCiudad(int codigoCiudad);

}
