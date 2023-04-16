package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.Repositorios.ComentarioRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepository comentarioRepository;
    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ComentarioGetDTO> listarComentariosProducto(int idProducto) throws Exception {
        return null;
    }

    @Override
    public List<ComentarioGetDTO> listarComentariosUsuario(String cedula) throws Exception {
        return null;
    }

    @Override
    public List<ComentarioGetDTO> listarComentariosFecha(LocalDate fecha) throws Exception {
        return null;
    }

    @Override
    public List<ComentarioGetDTO> listarComentariostexto(String text) throws Exception {
        return null;
    }

    @Override
    public int actualizarComentario(int codigoComentario, ComentarioDTO comentarioDTO) throws Exception {
        return 0;
    }

    @Override
    public ComentarioGetDTO obtenerComentario(int codigoComentario) throws Exception {
        return null;
    }

    @Override
    public int eliminarComentario(int codigoComentario) throws Exception {
        return 0;
    }
}
