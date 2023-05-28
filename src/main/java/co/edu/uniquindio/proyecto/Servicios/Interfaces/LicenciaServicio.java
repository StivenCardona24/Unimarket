package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.DTO.LicenciaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.LicenciaGetDTO;


import java.util.List;

public interface LicenciaServicio {

    int crearLicencia(LicenciaDTO licenciaDTO)  throws Exception;

    LicenciaGetDTO actualizarLicencia(int codigoLicencia, LicenciaDTO licenciaDTO) throws Exception;

    LicenciaGetDTO obtenerLicencia(int codigo) throws Exception;

    List<LicenciaGetDTO> listarLicencias();

    int eliminarLicencia(int codigoLicencia) throws Exception;
}
