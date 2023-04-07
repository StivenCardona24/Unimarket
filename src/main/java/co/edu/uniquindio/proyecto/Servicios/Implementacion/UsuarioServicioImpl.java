package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {


    //throws Exception
    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {


        return 0;
    }

    @Override
    public int eliminarUsuario(int idUsuario) throws Exception {


        usuarioRepository.deleteById(idUsuario);

        return idUsuario;
    }

    @Override
    public UsuarioDTO actualizarUsuario(int idUsuario, UsuarioDTO usuarioDTO) throws Exception {
        return null;
    }

    @Override
    public UsuarioGetDTO obtenerUsuario(int idUsuario) throws Exception {


        return convertir(obtener(idUsuario));
    }

    @Override
    public Usuario obtener(int idUsuario) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);

        return usuario.get();
    }

    private Usuario convertir(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setDireccion(usuarioDTO.getDireccion());
        usuario.setCedula(usuarioDTO.getCedula());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setFechaNacimiento((usuarioDTO.getFechaNacimiento()));

        return usuario;
    }

    private UsuarioGetDTO convertir(Usuario usuario) {

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getCodigo(),
                usuario.getUserName(),
                usuario.getPassword(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getTelefono(),
                usuario.getCedula(),
                usuario.getFechaNacimiento());


        return usuarioDTO;
    }


    //UsuarioRepository.save();
    //UsuarioRepository.findAll()
    //UsuarioRepository.exitsById();
    //UsuarioRepository.delete();
    //UsuarioRepository.FindbyID();
    //UsuarioRepository.count();
    //UsuarioRepository.DeletedAll();
}
