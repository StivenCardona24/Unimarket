package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Ciudad;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad,Integer> {

    @Query("SELECT c FROM Ciudad c WHERE c.nombre = ?1 and c.estadoObjeto='ACTIVE' ")
    Ciudad findCiudadByNombre(String nombre);

    @Query("SELECT c FROM Ciudad c WHERE c.nombre LIKE %?1% and c.estadoObjeto='ACTIVE'  order by c.nombre asc")
    List<Ciudad> findCiudadesByNombreAsc(String nombre);
    @Transactional
    @Modifying
    @Query("UPDATE Ciudad c SET c.estadoObjeto = :estado WHERE c.codigo = :codigo")
    void actualizarEstadoObjeto(int codigo, EstadoObjeto estado);


}
