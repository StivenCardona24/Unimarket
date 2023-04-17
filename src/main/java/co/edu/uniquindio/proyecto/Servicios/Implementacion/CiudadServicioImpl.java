package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadGetDTO;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CiudadServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CiudadServicioImpl implements CiudadServicio {

    private final CiudadRepository ciudadRepository;
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
    public CiudadGetDTO obtenerCiudadNombre(String nombre) throws Exception {
        return null;
    }

    @Override
    public int eliminarCiudad(int codigoCiudad) {
        return 0;
    }


}
