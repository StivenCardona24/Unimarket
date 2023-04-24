package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad,Integer> {

    //Repository.save();        -->llamar para guardar
    //Repository.findAll()      --> llamar para buscar todos
    //Repository.exitsById();   -->llamar para saber si exite algo por el campo (cambiar "Id" por el campo requerido)
    //Repository.delete();      --> llamar para eliminar un registro
    //Repository.FindbyID();    -->llamar para buscar algo por el campo (cambiar "Id" por el campo requerido)
    //Repository.count();       -->llamar para contar los registros
    //Repository.DeletedAll();  --> llamar para eliminar masivamente

    @Query("SELECT c FROM Ciudad c WHERE c.nombre = ?1")
    Ciudad findCiudadByNombre(String nombre);

    @Query("SELECT c FROM Ciudad c WHERE c.nombre LIKE %?1% order by c.nombre asc")
    List<Ciudad> findCiudadesByNombreAsc(String nombre);


}
