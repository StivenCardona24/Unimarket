package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.DTO.LicenciaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.LicenciaGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;


import java.util.List;

public interface LicenciaServicio {

    int crearLicencia(LicenciaDTO licenciaDTO)  throws Exception;

    LicenciaGetDTO actualizarEstadoObjeto(int codigo, EstadoObjeto estado) throws Exception ;
    LicenciaGetDTO actualizarLicencia(int codigoLicencia, LicenciaDTO licenciaDTO) throws Exception;

    LicenciaGetDTO obtenerLicencia(int codigo) throws Exception;

    List<LicenciaGetDTO> listarLicencias();
}
