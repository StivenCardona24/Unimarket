package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Comentario;
import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Comentario c SET c.estadoObjeto = :estado WHERE c.codigo = :codigo")
    void actualizarEstadoObjeto(int codigo, EstadoObjeto estado);
    @Query("SELECT c FROM Comentario c WHERE c.producto.codigo = :codigoProducto")
    List<Comentario> findByProducto(Integer codigoProducto);
    @Query("SELECT c FROM Comentario c WHERE c.usuario.codigo = :codigoUsuario")
    List<Comentario> findByUsuario(Integer codigoUsuario);
    @Query("SELECT c FROM Comentario c WHERE c.usuario.cedula = :cedulaUsuario")
    List<Comentario> findByUsuarioCedula(String cedulaUsuario);

    @Query("SELECT c FROM Comentario c WHERE c.fecha = :fecha")
    List<Comentario> findByFecha(LocalDate fecha);

    @Query("SELECT COUNT(c) FROM Comentario c WHERE c.producto.codigo = :codigoProducto")
    Integer countByProducto( Integer codigoProducto);

    @Query("SELECT c FROM Comentario c WHERE c.comentario LIKE %?1%")
    List<Comentario> findBycomentarioContaining(String comentario);


}
