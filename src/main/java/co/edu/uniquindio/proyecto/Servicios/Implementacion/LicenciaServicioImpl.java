package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Repositorios.LicenciaRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.LicenciaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LicenciaServicioImpl implements LicenciaServicio {

    private final LicenciaRepository licenciaRepository;
    private void validarExistencia(int codigo) throws Exception {
        boolean existe = licenciaRepository.existsById(codigo);
        if (!existe) {
            throw new Exception("El código: " + codigo + " no está asociado a ningúna Licencia");
        }
    }

}
