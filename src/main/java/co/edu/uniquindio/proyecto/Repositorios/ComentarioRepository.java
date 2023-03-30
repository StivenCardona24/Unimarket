package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {

    @Query("SELECT c FROM Comentario c WHERE c.producto.codigo = :codigoProducto")
    List<Comentario> findByProducto(Integer codigoProducto);

    @Query("SELECT c FROM Comentario c WHERE c.usuario.codigo = :codigoUsuario")
    List<Comentario> findByUsuario(Integer codigoUsuario);

    @Query("SELECT c FROM Comentario c WHERE c.fecha = :fecha")
    List<Comentario> findByFecha(LocalDate fecha);




    @Query("SELECT COUNT(c) FROM Comentario c WHERE c.producto.codigo = :codigoProducto")
    Long countByProducto( Integer codigoProducto);
    /**
         @Query("SELECT c FROM Comentario c WHERE LOWER(c.comentario) LIKE concat ( '%', :comentario, '%' )")
          List<Comentario> findBycomentarioContaining(String comentario);

    @Query("SELECT c.usuario FROM Comentario c GROUP BY c.usuario ORDER BY COUNT(c) DESC")
    Usuario findUsuarioWithMostComments();
    **/
}
