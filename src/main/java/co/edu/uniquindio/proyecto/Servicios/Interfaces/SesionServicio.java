package co.edu.uniquindio.proyecto.Servicios.Interfaces;


import co.edu.uniquindio.proyecto.Modelo.DTO.SesionDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.TokenDTO;

public interface SesionServicio {
    TokenDTO login(SesionDTO sesionDTO);
    void logout(int idUsuario);


}
