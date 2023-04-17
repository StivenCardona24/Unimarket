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

    // Obtener el detalle de venta con el código especificado:
    Optional<DetalleVenta> findByCodigo(int codigo);
    DetalleVenta findAllByOrderByPrecioDesc();
    DetalleVenta findTopByOrderByPrecioAsc();

    List<DetalleVenta> findByPrecioGreaterThan(double precioMinimo);

    List<DetalleVenta> findByVenta(Venta venta);

    // Obtener todos los detalles de venta ordenados por precio de forma ascendente
    List<DetalleVenta> findAllByOrderByPrecioAsc();

    //Obtener todos los detalles de venta que contengan un producto con el nombre especificado
    @Query("SELECT dv FROM DetalleVenta dv JOIN dv.productos p WHERE p.nombre  LIKE concat ( '%', :nombre, '%' )")
    List<DetalleVenta> findAllByProductoNombre(@Param("nombre") String nombre);

    //Obtener el número total de detalles de venta que existen:
    long count();
}
