package co.edu.uniquindio.proyecto.seguridad.servicios;
import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepository;
import co.edu.uniquindio.proyecto.seguridad.modelo.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository clienteRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> cliente = clienteRepo.findByEmailAndEnumRole(email,"CLIENTE");
        if(cliente.isEmpty()){
            Optional<Usuario> admin = clienteRepo.findByEmailAndEnumRole(email,"MODERADOR");
            if(admin.isEmpty())
                throw new UsernameNotFoundException("El usuario no existe");
            return UserDetailsImpl.build(admin.get());
        }else{
            return UserDetailsImpl.build(cliente.get());
        }
    }
}