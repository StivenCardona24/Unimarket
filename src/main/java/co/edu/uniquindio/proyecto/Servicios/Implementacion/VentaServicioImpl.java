package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.DTO.ventaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ventaGetDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.VentaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VentaServicioImpl implements VentaServicio {
    @Override
    public int crearCompra(ventaDTO ventaDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ventaGetDTO> listarComprasUsuarios(int codigoVenta) throws Exception {
        return null;
    }

    @Override
    public ventaGetDTO obtenerCompra(int codigoVenta) throws Exception {
        return null;
    }
}
