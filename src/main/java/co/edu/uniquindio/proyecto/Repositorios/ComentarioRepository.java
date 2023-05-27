package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Comentario;
import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {
<<<<<<< HEAD

    //Repository.save();        -->llamar para guardar
    //Repository.findAll()      --> llamar para buscar todos
    //Repository.exitsById();   -->llamar para saber si exite algo por el campo (cambiar "Id" por el campo requerido)
    //Repository.delete();      --> llamar para eliminar un registro
    //Repository.FindbyID();    -->llamar para buscar algo por el campo (cambiar "Id" por el campo requerido)
    //Repository.count();       -->llamar para contar los registros
    //Repository.DeletedAll();  --> llamar para eliminar masivamente

    @Query("SELECT c FROM Comentario c WHERE c.producto.codigo = :codigoProducto")
=======
    @Transactional
    @Modifying
    @Query("UPDATE Comentario c SET c.estadoObjeto = :estado WHERE c.codigo = :codigo")
    void actualizarEstadoObjeto(int codigo, EstadoObjeto estado);
    @Query("SELECT c FROM Comentario c WHERE c.producto.codigo = :codigoProducto and c.estadoObjeto='ACTIVE' ")
>>>>>>> Ajustes
    List<Comentario> findByProducto(Integer codigoProducto);
    @Query("SELECT c FROM Comentario c WHERE c.usuario.codigo = :codigoUsuario and c.estadoObjeto='ACTIVE'")
    List<Comentario> findByUsuario(Integer codigoUsuario);
    @Query("SELECT c FROM Comentario c WHERE c.usuario.cedula = :cedulaUsuario and c.estadoObjeto='ACTIVE'")
    List<Comentario> findByUsuarioCedula(String cedulaUsuario);
    @Query("SELECT c FROM Comentario c WHERE c.fecha = :fecha and c.estadoObjeto='ACTIVE'")
    List<Comentario> findByFecha(LocalDate fecha);
    @Query("SELECT COUNT(c) FROM Comentario c WHERE c.producto.codigo = :codigoProducto and c.estadoObjeto='ACTIVE'")
    Integer countByProducto( Integer codigoProducto);
    @Query("SELECT c FROM Comentario c WHERE c.comentario LIKE %?1% and c.estadoObjeto='ACTIVE'")
    List<Comentario> findBycomentarioContaining(String comentario);
}
