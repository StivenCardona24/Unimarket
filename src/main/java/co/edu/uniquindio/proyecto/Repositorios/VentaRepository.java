package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;

import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoObjeto;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoVenta;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Integer> {
    @Query("SELECT c FROM Venta c WHERE c.usuario.codigo = :idUsuario")
    List<Venta> findByUsuarioIdUsuario(int idUsuario);
    @Transactional
    @Modifying
    @Query("UPDATE Venta v  SET v.estadoObjeto = :estado WHERE v.codigo = :codigo and v.estadoObjeto='ACTIVE'")
    void actualizarEstadoObjeto(int codigo, EstadoObjeto estado);

    @Query("SELECT v FROM Venta v WHERE v.codigo = :codigoVenta and v.estadoObjeto='ACTIVE'")
    boolean findVentaIdActivo(int codigoVenta);
    @Transactional
    @Modifying
    @Query("UPDATE Venta v SET v.estado = :estado WHERE v.codigo = :codigo and v.estadoObjeto='ACTIVE'")
    void actualizarEstado( int codigo, EstadoVenta estado);

    @Transactional
    @Modifying
    @Query("UPDATE Venta v SET v.totalCompra = :total WHERE v.codigo = :codigo and v.estadoObjeto='ACTIVE'")
    void actualizarTotal(@Param("codigo") int codigo, @Param("total") double total);

    @Transactional
    @Modifying
    @Query("UPDATE Venta v SET v.fechaCompra = :fecha WHERE v.codigo = :codigo and v.estadoObjeto='ACTIVE'")
    void actualizarFecha(@Param("codigo") int codigo, @Param("fecha") LocalDate fecha);


    @Query("SELECT SUM(v.totalCompra) AS TOTALVENTA FROM Venta v WHERE v.fechaCompra >=:fecha and v.fechaCompra< :fechaFin")
    double findTotalMesAnio(Date fecha, Date fechaFin);




}
