package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {
//throws Exception
    @Autowired
    private UsuarioRepository usuarioRepository;
    //UsuarioRepository.save();
    //UsuarioRepository.findAll()
    //UsuarioRepository.exitsById();
    //UsuarioRepository.delete();
   //UsuarioRepository.FindbyID();
    //UsuarioRepository.count();
    //UsuarioRepository.DeletedAll();
}
