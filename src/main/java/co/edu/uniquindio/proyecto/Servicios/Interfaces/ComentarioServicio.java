package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioGetDTO;

import java.time.LocalDate;
import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;

    List<ComentarioGetDTO> listarComentariosProducto(int idProducto) throws Exception;
    List<ComentarioGetDTO> listarComentariosUsuario(String cedula) throws Exception;
    List<ComentarioGetDTO> listarComentariosFecha(LocalDate fecha) throws Exception;
    List<ComentarioGetDTO> listarComentariostexto(String text) throws Exception;

    int actualizarComentario(int codigoComentario, ComentarioDTO comentarioDTO) throws Exception;
    ComentarioGetDTO obtenerComentario(int codigoComentario) throws Exception;

    int eliminarComentario(int codigoComentario) throws Exception;
}
