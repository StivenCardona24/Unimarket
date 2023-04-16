package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Repositorios.TarjetaRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.TarjetaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TarjetaServicioImpl implements TarjetaServicio {

    private final TarjetaRepository tarjetaRepository;
    private void validarExistencia(int codigo) throws Exception {
        boolean existe = tarjetaRepository.existsById(codigo);
        if (!existe) {
            throw new Exception("El código: " + codigo + " no está asociado a ningúna Licencia");
        }
    }

}
