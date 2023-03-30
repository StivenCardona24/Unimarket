package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad,Integer> {

    @Query("SELECT c FROM Ciudad c")
    List<Ciudad> findAllCiudades();

    @Query("SELECT c FROM Ciudad c WHERE c.codigo = ?1")
    Ciudad findCiudadByCodigo(int codigo);

    @Query("SELECT c FROM Ciudad c WHERE c.nombre LIKE %?1% order by c.nombre asc")
    List<Ciudad> findCiudadesByNombre(String nombre);


}
