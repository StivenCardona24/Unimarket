package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.DetalleVenta;
import co.edu.uniquindio.proyecto.Modelo.Clases.Producto;
import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Integer> {
    //Repository.save();        -->llamar para guardar
    //Repository.findAll()      --> llamar para buscar todos
    //Repository.exitsById();   -->llamar para saber si exite algo por el campo (cambiar "Id" por el campo requerido)
    //Repository.delete();      --> llamar para eliminar un registro
    //Repository.FindbyID();    -->llamar para buscar algo por el campo (cambiar "Id" por el campo requerido)
    //Repository.count();       -->llamar para contar los registros
    //Repository.DeletedAll();  --> llamar para eliminar masivamente

    List<DetalleVenta> findByPrecioGreaterThan(double precioMinimo);
    List<DetalleVenta> findByUnidadesGreaterThan(int unidadesMinimas);
    @Query("SELECT d FROM DetalleVenta d WHERE d.venta.codigo = ?1")
    List<DetalleVenta> findAllByVenta(int codigoVenta);


}
