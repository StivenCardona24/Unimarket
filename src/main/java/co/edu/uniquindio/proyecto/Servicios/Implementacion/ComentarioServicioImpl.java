package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.Comentario;
import co.edu.uniquindio.proyecto.Modelo.Clases.Producto;
import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.EmailDTO;
import co.edu.uniquindio.proyecto.Repositorios.ComentarioRepository;
import co.edu.uniquindio.proyecto.Repositorios.ProductoRepository;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ComentarioRepository comentarioRepository;
    private final EmailServicio emailServicio;
    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        if (comentarioDTO.getComentario() != null && comentarioDTO.getComentario().length() > 500) {
            throw new Exception("El comentario no debe exceder los 500 caracteres.");
        }
        if (!productoRepository.existsById(comentarioDTO.getIdProducto())) {
            throw new Exception("El Producto no existe.");
        }
        if (!usuarioRepository.existsById(comentarioDTO.getIdUsuario())) {
            throw new Exception("El Usuario no existe");
        }
        comentarioDTO.setEstadoObjeto(EstadoObjeto.ACTIVE);
        Comentario comentarioGuardar=convertirDTOToAnEntity(comentarioDTO);
        Producto productoAsociado=productoRepository.findById(comentarioDTO.getIdProducto()).get();

        comentarioGuardar.setFecha(LocalDate.now());
        emailServicio.enviarEmail(new EmailDTO("Comentario producto", comentarioGuardar.getComentario(), productoAsociado.getUsuarioPropietario().getEmail()));
        return comentarioRepository.save(comentarioGuardar).getCodigo();
    }

    @Override
    public List<ComentarioGetDTO> listarComentariosProducto(int idProducto) throws Exception {
        List<ComentarioGetDTO> listComentariosDTO=new ArrayList<>();
        for(Comentario comentarioRecorer:comentarioRepository.findByProducto(idProducto)){
            ComentarioGetDTO nuevoComentarioDTO=convertirEntityToAnDTO(comentarioRecorer);
            listComentariosDTO.add(nuevoComentarioDTO);
        }
        return listComentariosDTO;
    }

    @Override
    public List<ComentarioGetDTO> listarComentariosUsuarioCedula(String cedula) throws Exception {
        List<ComentarioGetDTO> listComentariosDTO=new ArrayList<>();
        for(Comentario comentarioRecorer:comentarioRepository.findByUsuarioCedula(cedula)){
            ComentarioGetDTO nuevoComentarioDTO=convertirEntityToAnDTO(comentarioRecorer);
            listComentariosDTO.add(nuevoComentarioDTO);
        }
        return listComentariosDTO;
    }

    @Override
    public List<ComentarioGetDTO> listarComentariosUsuario(Integer codigo) throws Exception {
        List<ComentarioGetDTO> listComentariosDTO=new ArrayList<>();
        for(Comentario comentarioRecorer:comentarioRepository.findByUsuario(codigo)){
            ComentarioGetDTO nuevoComentarioDTO=convertirEntityToAnDTO(comentarioRecorer);
            listComentariosDTO.add(nuevoComentarioDTO);
        }
        return listComentariosDTO;
    }

    @Override
    public List<ComentarioGetDTO> listarComentariosFecha(LocalDate fecha) throws Exception {
        List<ComentarioGetDTO> listComentariosDTO=new ArrayList<>();
        for(Comentario comentarioRecorer:comentarioRepository.findByFecha(fecha)){
            ComentarioGetDTO nuevoComentarioDTO=convertirEntityToAnDTO(comentarioRecorer);
            listComentariosDTO.add(nuevoComentarioDTO);
        }
        return listComentariosDTO;
    }

    @Override
    public List<ComentarioGetDTO> listarComentariostexto(String text) throws Exception {
        List<ComentarioGetDTO> listComentariosDTO=new ArrayList<>();
        for(Comentario comentarioRecorer:comentarioRepository.findBycomentarioContaining(text)){
            ComentarioGetDTO nuevoComentarioDTO=convertirEntityToAnDTO(comentarioRecorer);
            listComentariosDTO.add(nuevoComentarioDTO);
        }
        return listComentariosDTO;
    }

    @Override
    public Integer countComentarioProducto(Integer codigo) throws Exception {
        return comentarioRepository.countByProducto(codigo);
    }

    @Override
    public ComentarioGetDTO obtenerComentario(int codigoComentario) throws Exception {
        return convertirEntityToAnDTO(comentarioRepository.findById(codigoComentario).get());
    }

    @Override
    public ComentarioGetDTO actualizarComentario(int codigoComentario, ComentarioDTO comentarioDTO) throws Exception {
        validarExistencia(codigoComentario);
        if (comentarioDTO.getComentario() != null && comentarioDTO.getComentario().length() > 500) {
            throw new Exception("El comentario no debe exceder los 500 caracteres.");
        }
        if (!productoRepository.existsById(comentarioDTO.getIdProducto())) {
            throw new Exception("El Producto no existe.");
        }
        if (!usuarioRepository.existsById(comentarioDTO.getIdUsuario())){
            throw new Exception("El Usuario no existe");
        }
        Comentario actualizarComentario=convertirDTOToAnEntity(comentarioDTO);
        actualizarComentario.setCodigo(codigoComentario);
        actualizarComentario.setFecha(LocalDate.now());
        return convertirEntityToAnDTO(comentarioRepository.save(actualizarComentario));
    }
    @Override
    public int eliminarComentario(int codigoComentario) throws Exception {
        validarExistencia(codigoComentario);
        comentarioRepository.deleteById(codigoComentario);
        return codigoComentario;
    }
    private void validarExistencia(int codigo) throws Exception {
        boolean existe = comentarioRepository.existsById(codigo);
        if (!existe) {
            throw new Exception("El código: " + codigo + " no está asociado a ningún comentario");
        }
    }
    public ComentarioGetDTO convertirEntityToAnDTO (Comentario comentarioConvertir) throws Exception{
        ComentarioGetDTO nuevoComentario=new ComentarioGetDTO();
        nuevoComentario.setComentario(comentarioConvertir.getComentario());
        nuevoComentario.setIdComentario(comentarioConvertir.getCodigo());
        nuevoComentario.setFechaComentario(comentarioConvertir.getFecha());
        nuevoComentario.setIdUsuario(comentarioConvertir.getUsuario().getCodigo());
        nuevoComentario.setIdProducto(comentarioConvertir.getProducto().getCodigo());
        return nuevoComentario;
    }
    public Comentario convertirDTOToAnEntity (ComentarioDTO comentarioConvertir) throws Exception{
        Comentario nuevoComentario= new Comentario();
        nuevoComentario.setComentario(comentarioConvertir.getComentario());
        nuevoComentario.setEstadoObjeto(comentarioConvertir.getEstadoObjeto());
        nuevoComentario.setUsuario(usuarioRepository.findById(comentarioConvertir.getIdUsuario()).get());
        nuevoComentario.setProducto(productoRepository.findById(comentarioConvertir.getIdProducto()).get());
        return nuevoComentario;
    }
}
