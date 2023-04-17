package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import co.edu.uniquindio.proyecto.exepciones.ExceptionEnUso;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.print.AttributeException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {


    //throws Exception
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {
        Optional<Usuario> buscadoCedula = usuarioRepository.buscarUsuarioPorCedula(usuarioDTO.getCedula());
        if(buscadoCedula.isPresent()){
            throw new Exception("La cédula ya se encuentra en uso");
        }
        Optional<Usuario> buscadoEmail = usuarioRepository.findByEmail(usuarioDTO.getEmail());
        if(!buscadoEmail.isPresent()){
            throw new Exception("El email ya se encuentra en uso");
        }
        Usuario nuevo = convertir(usuarioDTO);
        nuevo.setPassword( passwordEncoder.encode(nuevo.getPassword()) );
        Usuario registro = usuarioRepository.save(nuevo);
        return registro.getCodigo();


    }

    @Override
    public int eliminarUsuario(int cedulaUsuario) throws Exception {


        usuarioRepository.deleteById(cedulaUsuario);

        return cedulaUsuario;
    }

    @Override
    public UsuarioGetDTO actualizarUsuario(int  codigoUsuario, UsuarioDTO usuarioDTO) throws Exception, ExceptionEnUso {

        // Verificar que el correo no esté en uso
        Usuario emailExistente = usuarioRepository.buscarUsuarioPorEmail(usuarioDTO.getEmail());
        if (emailExistente != null && emailExistente.getCodigo()!= codigoUsuario) {
            throw new ExceptionEnUso("El correo " + usuarioDTO.getEmail() + " ya está en uso");
        }
        // Verificar que la cédula no esté en uso
        Optional<Usuario> cedulaExistente = usuarioRepository.buscarUsuarioPorCedula(usuarioDTO.getCedula());
        if (cedulaExistente.isPresent() && cedulaExistente.get().getCodigo() != codigoUsuario) {
            throw new ExceptionEnUso("La cédula " + usuarioDTO.getCedula() + " ya está en uso");
        }

        validarExiste(codigoUsuario);

        Usuario usuario = convertir(usuarioDTO);
        usuario.setCodigo(codigoUsuario);

        return convertirDTO(usuarioRepository.save(usuario));

    }


    private void validarExiste(int codigoUsurio) throws Exception {
        boolean existe = usuarioRepository.existsById(Integer.valueOf(codigoUsurio));

        if (!existe) {
            throw new Exception("El código " + codigoUsurio + " no está asociado a ningún usuario");
        }

    }

    @Override
    public UsuarioGetDTO obtenerUsuario(int cedulaUsuario) throws Exception {


        return convertirDTO(obtener(cedulaUsuario));
    }

    @Override
    public Usuario obtener(int idUsuario) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);

        return usuario.get();
    }

    @Override
    public Usuario obtenerporCorreo(String gmail) throws Exception {
        return null;
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

    private UsuarioGetDTO convertirDTO(Usuario usuario) {

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
