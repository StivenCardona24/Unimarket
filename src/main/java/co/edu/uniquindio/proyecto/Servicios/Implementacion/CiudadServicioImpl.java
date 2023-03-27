package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadGetDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CiudadServicio;
import org.springframework.stereotype.Service;

@Service
public class CiudadServicioImpl implements CiudadServicio {

    @Override
    public int crearCiudad(CiudadDTO ciudadDTO) {
        return 0;
    }

    @Override
    public int actualizarCiudad(int codigoCiudad, CiudadDTO ciudadDTO) {
        return 0;
    }

    @Override
    public CiudadGetDTO obtenerCiudad(int codigoCiudad) {
        return null;
    }

    @Override
    public int eliminarCiudad(int codigoCiudad) {
        return 0;
    }
}
