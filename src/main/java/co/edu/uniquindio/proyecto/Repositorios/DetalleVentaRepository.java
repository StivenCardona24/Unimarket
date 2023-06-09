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
    List<DetalleVenta> findByPrecioUnitarioGreaterThan(double precioMinimo);
    List<DetalleVenta> findByUnidadesGreaterThan(int unidadesMinimas);
    @Query("SELECT d FROM DetalleVenta d WHERE d.venta.codigo = ?1")
    List<DetalleVenta> findAllByVenta(int codigoVenta);

    @Query("SELECT d FROM DetalleVenta d WHERE d.producto.codigo = ?1")
    List<DetalleVenta> findAllByProductoID(int codigoVenta);

    // Obtener todos los detalles de venta ordenados por precio de forma ascendente
    List<DetalleVenta> findAllByOrderByPrecioUnitarioAsc();

    //Obtener todos los detalles de venta que contengan un producto con el nombre especificado
    @Query("SELECT dv FROM DetalleVenta dv WHERE dv.producto.nombre  LIKE concat ( '%', :nombre, '%' )")
    List<DetalleVenta> findAllByProductoNombre(@Param("nombre") String nombre);

    //Obtener el número total de detalles de venta que existen:
    long count();
}
