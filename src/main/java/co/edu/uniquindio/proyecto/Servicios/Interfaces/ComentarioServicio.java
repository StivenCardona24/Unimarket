package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;

import java.time.LocalDate;
import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;
    ComentarioGetDTO actualizarEstadoObjeto(int codigo, EstadoObjeto estado) throws Exception ;
    ComentarioGetDTO actualizarComentario(int codigoComentario, ComentarioDTO comentarioDTO) throws Exception;
    int eliminarComentario(int codigoComentario) throws Exception;

    List<ComentarioGetDTO> listarComentariosProducto(int idProducto) throws Exception;
    List<ComentarioGetDTO> listarComentariosUsuarioCedula(String cedula) throws Exception;
    List<ComentarioGetDTO> listarComentariosUsuario(Integer cedula) throws Exception;
    List<ComentarioGetDTO> listarComentariosFecha(LocalDate fecha) throws Exception;
    List<ComentarioGetDTO> listarComentariostexto(String text) throws Exception;
    Integer countComentarioProducto(Integer codigo) throws Exception;
    ComentarioGetDTO obtenerComentario(int codigoComentario) throws Exception;

}
