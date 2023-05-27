package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad,Integer> {

    @Query("SELECT c FROM Ciudad c WHERE c.nombre = ?1 and c.estadoObjeto='ACTIVE' ")
    Ciudad findCiudadByNombre(String nombre);

    @Query("SELECT c FROM Ciudad c WHERE c.nombre LIKE %?1% and c.estadoObjeto='ACTIVE'  order by c.nombre asc")
    List<Ciudad> findCiudadesByNombreAsc(String nombre);



}
