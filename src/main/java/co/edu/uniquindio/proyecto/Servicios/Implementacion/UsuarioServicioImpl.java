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
        System.out.println(usuarioDTO.getUserName());
        Optional<Usuario> buscadoCedula = usuarioRepository.buscarUsuarioPorCedula(usuarioDTO.getCedula());
        if(buscadoCedula.isPresent()){
            throw new Exception("La cédula ya se encuentra en uso");
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
    public UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception {



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
    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception {


        return convertirDTO(obtener(codigoUsuario));
    }

    @Override
    public Usuario obtener(int codigoUsuario) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findById(codigoUsuario);

        if (usuario.isEmpty()) {
            throw new Exception("El código " + codigoUsuario + " no está asociado a ningún usuario");
        }

        return usuario.get();
    }

    @Override
    public Usuario obtenerPorCodigo(int codigo) throws Exception {
        return null;
    }

    @Override
    public Usuario obtenerporCorreo(String gmail) throws Exception {


        Optional<Usuario> usuario = usuarioRepository.findByEmail(gmail);

        if (usuario.isEmpty()) {
            throw new Exception("El gmail " + gmail + " no está asociado a ningún usuario");
        }

        return usuario.get();
    }

    private Usuario convertir(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setActivo(true);
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setDireccion(usuarioDTO.getDireccion());
        usuario.setCedula(usuarioDTO.getCedula());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setUserName(usuarioDTO.getUserName());
        usuario.setFechaNacimiento((usuarioDTO.getFechaNacimiento()));

        return usuario;
    }

    private UsuarioGetDTO convertirDTO(Usuario usuario) {

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getCodigo(),
                usuario.getUserName(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getTelefono(),
                usuario.getCedula(),
                usuario.getFechaNacimiento(),true);


        return usuarioDTO;
    }

}
