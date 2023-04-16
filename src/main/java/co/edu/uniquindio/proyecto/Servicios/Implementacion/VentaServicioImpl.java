package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.VentaGetDTO;
import co.edu.uniquindio.proyecto.Repositorios.VentaRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.VentaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VentaServicioImpl implements VentaServicio {

    private final VentaRepository ventaRepository;
    @Override
    public int crearVenta(VentaDTO ciudadDTO) throws Exception {
        return 0;
    }

    @Override
    public int actualizarCiudad(int codigoCiudad, VentaDTO ciudadDTO) throws Exception {
        return 0;
    }

    @Override
    public int eliminarCiudad(int codigoCiudad) throws Exception {
        return 0;
    }

    @Override
    public VentaGetDTO obtenerCiudad(int codigoCiudad) throws Exception {
        return null;
    }

    private void validarExistencia(int codigo) throws Exception {
        boolean existe = ventaRepository.existsById(codigo);
        if (!existe) {
            throw new Exception("El código: " + codigo + " no está asociado a ningúna Licencia");
        }
    }
}
