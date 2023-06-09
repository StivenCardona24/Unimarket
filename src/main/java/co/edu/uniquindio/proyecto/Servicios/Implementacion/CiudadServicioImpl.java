package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.Ciudad;
import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.CiudadGetDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CiudadServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CiudadServicioImpl implements CiudadServicio {

    private final CiudadRepository ciudadRepository;
    @Override
    public int crearCiudad(CiudadDTO ciudadDTO) throws  Exception{
        if (ciudadDTO.getNombre() != null && ciudadDTO.getNombre().length() > 50) {
            throw new Exception("El nombre de la ciudad no debe exceder los 50 caracteres.");
        }
        Ciudad ciudadGuardarini=convertirDTOToEntity(ciudadDTO);
        ciudadGuardarini.setEstadoObjeto(EstadoObjeto.ACTIVE);
        Ciudad ciudadGuardar=ciudadRepository.save(ciudadGuardarini);
        return ciudadGuardar.getCodigo();
    }



    @Override
    public CiudadGetDTO actualizarCiudad(int codigoCiudad, CiudadDTO ciudadDTO) throws Exception {
        validarExistencia(codigoCiudad);
        if (ciudadDTO.getNombre() != null && ciudadDTO.getNombre().length() > 50) {
            throw new Exception("El nombre de la ciudad no debe exceder los 50 caracteres.");
        }
        Ciudad actualizarCiudad=convertirDTOToEntity(ciudadDTO);
        actualizarCiudad.setCodigo(codigoCiudad);
        return convertirEntityToDTO(ciudadRepository.save(actualizarCiudad));
    }

    @Override
    public CiudadGetDTO obtenerCiudad(int codigoCiudad) throws Exception {
        Optional<Ciudad> ciudadActual=ciudadRepository.findById(codigoCiudad);
        if (ciudadActual.isEmpty()) {
            throw new Exception("El código " + codigoCiudad + " no está asociado a ningúna ciudad");
        }
        return convertirEntityToDTO(ciudadActual.get());
    }

    @Override
    public List<CiudadGetDTO> obtenerCiudadNombre(String nombre) throws Exception {
        List<CiudadGetDTO> listaCiudadDTO= new ArrayList<>();
        if(ciudadRepository.findCiudadesByNombreAsc(nombre).size()>0){
            for(Ciudad ciudadActual:ciudadRepository.findCiudadesByNombreAsc(nombre)){
                CiudadGetDTO nuevaCiudad=convertirEntityToDTO(ciudadActual);
                listaCiudadDTO.add(nuevaCiudad);
            }
        }
        if(listaCiudadDTO.size()==0){
            throw new Exception("El conjunto de palabras: " + nombre + " no está asociado a ningúna Ciudad");
        }
        return listaCiudadDTO;
    }

    @Override
    public CiudadGetDTO obtenerCiudadNombreExacto(String nombre) throws Exception {
        Ciudad ciudadActual= ciudadRepository.findCiudadByNombre(nombre);
        if (ciudadActual ==null) {
            throw new Exception("El nombre: " + nombre + " no está asociado a ningúna Ciudad");
        }
        return convertirEntityToDTO(ciudadActual);
    }

    @Override
    public List<CiudadGetDTO> obtenerCiudades() throws Exception {
        List<CiudadGetDTO> listaCiudades=new ArrayList<>();
        if (ciudadRepository.findAll().size()>0){
            for(Ciudad ciudadActual:ciudadRepository.findAll()){
                listaCiudades.add(convertirEntityToDTO(ciudadActual));
            }
        }
        if (listaCiudades ==null) {
            throw new Exception("no Se ecneutran Ciudades");
        }
        return listaCiudades;
    }

    @Override
    public int eliminarCiudad(int codigoCiudad) throws Exception {
        validarExistencia(codigoCiudad);
        ciudadRepository.actualizarEstadoObjeto(codigoCiudad, EstadoObjeto.INACTIVE);
        return codigoCiudad;
    }

    private void validarExistencia(int idCiudad) throws Exception {
        boolean existe = ciudadRepository.existsById(idCiudad);
        Ciudad ciudadActual= ciudadRepository.findCiudadByNombre(ciudadRepository.findById(idCiudad).get().getNombre());

        if (!existe) {
            throw new Exception("El código: " + idCiudad + " no está asociado a ningúna ciudad");
        }
        if(ciudadActual==null){
            throw new Exception("El código: " + idCiudad + "Se encuentra inactivo");
        }
    }
    public CiudadGetDTO convertirEntityToDTO(Ciudad ciudadConvertir){
        CiudadGetDTO nuevaCiudad=new CiudadGetDTO();
        nuevaCiudad.setNombre(ciudadConvertir.getNombre());
        nuevaCiudad.setCodigo(ciudadConvertir.getCodigo());
        List<UsuarioDTO> usuariosDTOs = new ArrayList<>();
        if (ciudadConvertir.getUsuarios() != null) { // Verificar si la lista es nula
            for (Usuario usuariosRecorer : ciudadConvertir.getUsuarios()) {
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.setNombre(usuariosRecorer.getNombre());
                usuario.setEmail(usuariosRecorer.getEmail());
                usuario.setDireccion(usuariosRecorer.getDireccion());
                usuario.setCedula(usuariosRecorer.getCedula());
                usuario.setTelefono(usuariosRecorer.getTelefono());
                usuario.setPassword(usuariosRecorer.getPassword());
                usuario.setUserName(usuariosRecorer.getUserName());
                usuario.setFechaNacimiento((usuariosRecorer.getFechaNacimiento()));
                usuariosDTOs.add(usuario);
            }
        }
        nuevaCiudad.setUsuarios(usuariosDTOs);
        return nuevaCiudad;
    }

    public Ciudad convertirDTOToEntity(CiudadDTO ciudadConvertir){
        Ciudad nuevaCiudad=new Ciudad();
        nuevaCiudad.setNombre(ciudadConvertir.getNombre());
        return nuevaCiudad;
    }
}