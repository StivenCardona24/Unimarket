package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;

public interface UsuarioServicio {
int crearUsuario(UsuarioDTO usuarioDTO) throws Exception;

int eliminarUsuario(int idUsuario)throws Exception;

UsuarioDTO actualizarUsuario(int idUsuario,UsuarioDTO usuarioDTO)throws Exception;

UsuarioGetDTO obtenerUsuario (int idUsuario) throws Exception;

Usuario obtener (int idUsuario)throws Exception;






}
