package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Clases.Licencia;
import co.edu.uniquindio.proyecto.Modelo.DTO.LicenciaDTO;
import co.edu.uniquindio.proyecto.Modelo.DTO.LicenciaGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import co.edu.uniquindio.proyecto.Repositorios.LicenciaRepository;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.LicenciaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LicenciaServicioImpl implements LicenciaServicio {

    private final LicenciaRepository licenciaRepository;

    @Override
    public List<LicenciaGetDTO> listarLicencias(){
        List<Licencia> licencias = licenciaRepository.findAll();
        List<LicenciaGetDTO>  licenciasGet = new ArrayList<>();

        for (Licencia l: licencias) {

            //System.out.println(p.getNombre());
            LicenciaGetDTO lic = convertirDTO(l);
            licenciasGet.add(lic);


        }
        return licenciasGet;
    }

    @Override
    public int eliminarLicencia(int codigoLicencia) throws Exception {
        validarExiste(codigoLicencia);
        licenciaRepository.actualizarEstadoObjeto(codigoLicencia, EstadoObjeto.INACTIVE);
        return codigoLicencia;
    }

    @Override
    public int crearLicencia(LicenciaDTO licenciaDTO)  throws Exception{
        Optional<Licencia> buscadoNombre = licenciaRepository.findLicenciasByNombre(licenciaDTO.getNombre().toLowerCase());
        if(buscadoNombre.isPresent()){
            throw new Exception("Ya existe una licencia con ese nombre o similar");
        }
        Optional<Licencia> buscadoDiasPrioridad = licenciaRepository.findByDiasActivoProductoAndPrioridad(licenciaDTO.getDiasActivoProducto(), licenciaDTO.getPrioridad());
        if(buscadoDiasPrioridad.isPresent()){
            throw new Exception("Ya existe una licencia similar, (dias, prioridad)");
        }
        Licencia nueva = convertir(licenciaDTO);
        nueva.setEstadoObjeto(EstadoObjeto.ACTIVE);
        Licencia registro = licenciaRepository.save(nueva);
        return  registro.getCodigo();
    }

    @Override
    public LicenciaGetDTO actualizarLicencia(int codigoLicencia, LicenciaDTO licenciaDTO) throws Exception{

        validarExiste(codigoLicencia);

        Licencia licencia = convertir(licenciaDTO);
        licencia.setCodigo(codigoLicencia);

        return convertirDTO(licenciaRepository.save(licencia));

    };

    @Override
    public LicenciaGetDTO obtenerLicencia(int codigo) throws Exception {

        validarExiste(codigo);

        Optional<Licencia> licencia = licenciaRepository.findById(codigo);

        return convertirDTO(licencia.get());
    };


    private void validarExiste(int codigo) throws Exception {
        boolean existe = licenciaRepository.existsById(Integer.valueOf(codigo));
        boolean existe2 = licenciaRepository.findLicenciaIdActivo(codigo);

        if (!existe) {
            throw new Exception("El código " + codigo + " no está asociado a ningúna licencia");
        }
        if (!existe2) {
            throw new Exception("El código " + codigo + " Se encuentra inactivo");
        }

    }

    private Licencia convertir(LicenciaDTO licenciaDTO) {

        Licencia licencia = new Licencia();
        licencia.setNombre(licenciaDTO.getNombre());
        licencia.setPrecio(licenciaDTO.getPrecio());
        licencia.setDiasActivoProducto(licenciaDTO.getDiasActivoProducto());
        licencia.setPrioridad(licenciaDTO.getPrioridad());

        return licencia;
    }

    private LicenciaGetDTO convertirDTO(Licencia licencia) {

        LicenciaGetDTO licenciaGetDTO = new LicenciaGetDTO(
                licencia.getCodigo(),
                licencia.getNombre(),
                licencia.getPrecio(),
                licencia.getDiasActivoProducto(),
                licencia.getPrioridad()
        );


        return licenciaGetDTO;
    }

}
