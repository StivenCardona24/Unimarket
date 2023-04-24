package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.*;
import co.edu.uniquindio.proyecto.Modelo.DTO.*;
import co.edu.uniquindio.proyecto.Repositorios.TarjetaRepository;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.TarjetaServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TarjetaServicioImpl implements  TarjetaServicio {
    @Autowired
    private TarjetaRepository tarjetaRepository;
    private final UsuarioRepository usuarioRepository;


    private void validarExistencia(int codigo) throws Exception {
        boolean existe = tarjetaRepository.existsById(codigo);
        if (!existe) {
            throw new Exception("El código: " + codigo + " no está asociado a ningúna Licencia");
        }
    }


    @Override
    public int crearTarjeta(TarjetaDTO tarjetaDTO) throws Exception {

        return tarjetaRepository.save(convertirDTOToEntity(tarjetaDTO)).getCodigo();
    }

    @Override
    public TarjetaGetDto obtenerTarjeta(int codigoTarjeta) throws Exception {
        Optional<Tarjeta> tarjetaActual=tarjetaRepository.findById(codigoTarjeta);
        if (tarjetaActual.isEmpty()) {
            throw new Exception("El código " + codigoTarjeta + " no está asociado a ningúna ciudad");
        }
        return convertirEntityToDTO(tarjetaActual.get());
    }

    @Override
    public int eliminarTarjeta(int codigoTarjeta) throws Exception {

        tarjetaRepository.deleteById(codigoTarjeta);

        return codigoTarjeta;


    }

    @Override
    public TarjetaGetDto actualizarTarjeta(int codigoTarjeta, TarjetaDTO terjetaDTO) throws Exception {



        boolean existe = tarjetaRepository.existsById(Integer.valueOf(codigoTarjeta));

        Tarjeta tarjeta = convertirDTOToEntity(terjetaDTO);
        tarjeta.setCodigo(codigoTarjeta);

        return convertirEntityToDTO(tarjetaRepository.save(tarjeta));




    }

    @Override
    public List<TarjetaGetDto> obtenerTajertasUsuario(int codigo) throws Exception {

        boolean existe = usuarioRepository.existsById(Integer.valueOf(codigo));

        if (!existe) {
            throw new Exception("El código " + codigo + " no está asociado a ningún usuario");
        }

        Optional<Usuario> user = usuarioRepository.findByCodigo(codigo);

        List<Tarjeta> tarjetas = tarjetaRepository.findTarjetaByUsuario(user.get());

        List <TarjetaGetDto> tarjetasDTO = new ArrayList<>();

        for (Tarjeta tarjeta: tarjetas) {
            TarjetaGetDto t = convertirEntityToDTO(tarjeta);
            tarjetasDTO.add(t);
        }

        return tarjetasDTO;
    }

    public TarjetaGetDto convertirEntityToDTO(Tarjeta tarjetaConvertir){
        TarjetaGetDto nuevaTarjeta=new TarjetaGetDto();
        nuevaTarjeta.setNombre(tarjetaConvertir.getNombre());
        nuevaTarjeta.setCodigo(tarjetaConvertir.getCodigo());
        List<UsuarioDTO> usuariosDTOs = new ArrayList<>();
        if (tarjetaConvertir.getUsuario() != null) { // Verificar si la lista es nula
            for (Usuario usuariosRecorer : tarjetaConvertir.getUsuario()) {
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
       nuevaTarjeta.setUsuario(usuariosDTOs);
        nuevaTarjeta.setEstado(tarjetaConvertir.getEstado());
        nuevaTarjeta.setCVV(tarjetaConvertir.getCVV());
        nuevaTarjeta.setEstado(tarjetaConvertir.getEstado());
        nuevaTarjeta.setNumero(tarjetaConvertir.getNumero());
        nuevaTarjeta.setFecha(tarjetaConvertir.getFecha());
        List<VentaDTO> ventasDTOs = new ArrayList<>();
        if (tarjetaConvertir.getCompras() != null) { // Verificar si la lista es nula
            for (Venta ventasRecorer : tarjetaConvertir.getCompras()) {
                VentaDTO venta = new VentaDTO();

                venta.setEstado(ventasRecorer.getEstado());
                venta.setFechaCompra(ventasRecorer.getFechaCompra());
                venta.setMetodoPago(ventasRecorer.getMetodoPago());
                venta.setTotalCompra(ventasRecorer.getTotalCompra());
                ventasDTOs.add(venta);
            }
        }
        return nuevaTarjeta;
    }


    public Tarjeta convertirDTOToEntity(TarjetaDTO tarjetaDTO){
        Tarjeta nuevaTarjeta=new Tarjeta();
        nuevaTarjeta.setNombre(tarjetaDTO.getNombre());
        nuevaTarjeta.setCVV(tarjetaDTO.getCVV());
        nuevaTarjeta.setFecha(tarjetaDTO.getFecha());
        nuevaTarjeta.setEstado(tarjetaDTO.getEstado());
        nuevaTarjeta.setTipo(tarjetaDTO.getTipo());
        nuevaTarjeta.setDinero(tarjetaDTO.getDinero());
        nuevaTarjeta.setNumero(tarjetaDTO.getNumero());
        return nuevaTarjeta;
    }
}
