package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Licencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LicenciaRepository extends JpaRepository<Licencia,Integer> {

    @Query("SELECT l FROM Licencia l WHERE LOWER(l.nombre) LIKE concat ( '%', :nombre, '%' )")
    Optional<Licencia> findLicenciasByNombre(String nombre);

    Optional<Licencia> findByDiasActivoProductoAndPrioridad(int diasActivoProductom, int prioridad);


    @Query("SELECT l FROM Licencia l WHERE l.usuarios IS NOT EMPTY")
    List<Licencia> findLicenciasWithUsuarios();

    @Query("SELECT l FROM Licencia l WHERE l.usuarios IS EMPTY")
    List<Licencia> findLicenciasWithoutUsuarios();

}
