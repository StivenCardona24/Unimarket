package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Comentario;
import co.edu.uniquindio.proyecto.Modelo.Clases.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta,Integer> {
  //  @Query("SELECT c FROM Tarjeta c WHERE c.usuario.codigo = :codigoUsuario")
   // List<Tarjeta> findByUsuario(Integer codigoUsuario);


  //  List<Tarjeta> findTarjetaByUsuario(Integer codigo);







    @Query("SELECT t FROM Tarjeta t WHERE t.dinero >= :saldo")
    List<Tarjeta> findBySaldo(double saldo);
    @Query("SELECT t FROM Tarjeta t WHERE UPPER(t.estado) = :estado")
    List<Tarjeta> findByEstado(String estado);
    @Query("SELECT t FROM Tarjeta t WHERE UPPER(t.tipo) = :tipo")
    List<Tarjeta> findByTipo(String tipo);
    @Query("SELECT t FROM Tarjeta t JOIN t.compras v")
    List<Tarjeta> findTarjetasUtilizadasEnCompras();
    @Query("SELECT t FROM Tarjeta t WHERE t.fecha < :fecha")
    List<Tarjeta> findByFechaVencimientoAnterior(LocalDate fecha);

    @Query("SELECT SUM(t.dinero) FROM Tarjeta t JOIN t.usuario u WHERE u.codigo = :codigoUsuario")
    double sumSaldoByUsuario(String codigoUsuario);
    /**
    List<Tarjeta> tarjetasSaldoNulo = tarjetaRepository.findByDineroIsNull();
     List<Tarjeta> tarjetasFechaVencimientoAfter = tarjetaRepository.findByFechaAfter(LocalDate.of(2024, 1, 1));

    List<Tarjeta> tarjetasNombreTitularLike = tarjetaRepository.findByNombreContaining("García");
**/

}
