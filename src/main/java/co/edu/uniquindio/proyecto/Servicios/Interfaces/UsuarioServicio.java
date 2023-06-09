package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.exepciones.ExceptionEnUso;

import java.util.List;

public interface UsuarioServicio {
    int crearUsuario(UsuarioDTO usuarioDTO) throws Exception;

    int eliminarUsuario(int cedulaUsuario)throws Exception;

    UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception;

    UsuarioGetDTO obtenerUsuario (int codigoUsurio) throws Exception;


    Usuario obtener (int codigoUsuario)throws Exception;

    Usuario obtenerporCorreo (String gmail)throws Exception;

    List<UsuarioGetDTO> listarUsuarios();

    int generarCodigoContrasenia(String email) throws Exception;

    int recuperarContrasenia(String email, String codigo, String password) throws Exception;


}
