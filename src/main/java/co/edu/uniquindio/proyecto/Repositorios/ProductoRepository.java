package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Producto;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    @Query("SELECT p FROM Producto p WHERE p.categorias = :categoria")
    List<Producto> findProductoByCategorias(String categoria);

    @Query("SELECT p FROM Producto p WHERE p.estado = :estado")
    List<Producto> findProductoByEstado(String estado);

    @Query("SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE concat('%', :nombre, '%')")
    List<Producto> findProductoByNombre(String nombre);

    @Query("SELECT p FROM Producto p WHERE p.precioUnitario BETWEEN :precioMin AND :precioMax")
    List<Producto> findProductoByPrecioUnitario(double precioMin, double precioMax);

    @Query("SELECT p FROM Producto p JOIN Usuario u WHERE u.codigo = :codigo")
    List<Producto> findProductoByUsuarioPropietario(int codigo);

    @Query("SELECT p FROM Producto p JOIN Usuario u WHERE  p.nombre = :nombre AND u.codigo = :vendedor")
    Optional<Producto> buscarProductoPorNombreYVendedor(String nombre, int vendedor);

    @Modifying
    @Query("UPDATE Producto p SET p.unidades = :unidades WHERE p.codigo = :codigoProducto")
    void actualizarUnidades(@Param("codigoProducto") int codigo, @Param("unidades") int unidades);

    @Modifying
    @Query("UPDATE Producto p SET p.estado = :estado WHERE p.codigo = :codigo")
    void actualizarEstado(int codigo, EstadoProducto estado);
    List<Producto> findProductoByFavoritoUsuarios(int codigo);




}
