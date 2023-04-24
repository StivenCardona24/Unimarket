package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Producto;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.EstadoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    @Query("SELECT p FROM Producto  p where  p.disponible = true order by p.prioridad desc")
    List<Producto> findAll();


    @Query("SELECT p FROM Producto p join p.categorias c WHERE c = :categoria AND p.disponible = true order by p.prioridad desc")
    List<Producto> findProductoByCategoriasAndDisponible(Categoria categoria);

    @Query("SELECT p FROM Producto p WHERE p.estado = :estado AND p.disponible = true order by p.prioridad desc")
    List<Producto> findProductoByEstado(EstadoProducto estado);

    @Query("SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE concat('%', :nombre, '%') AND p.disponible = true order by p.prioridad desc")
    List<Producto> findProductoByNombre(String nombre);

    @Query("SELECT p FROM Producto p WHERE p.precioUnitario BETWEEN :precioMin AND :precioMax AND p.disponible = true order by p.prioridad desc")
    List<Producto> findProductoByPrecioUnitario(double precioMin, double precioMax);

    @Query("SELECT p FROM Producto p WHERE p.usuarioPropietario.codigo = :codigo AND p.disponible = true order by p.prioridad desc")
    List<Producto> listarProductosPropietario(int codigo);

    @Query("SELECT p FROM Producto p JOIN Usuario u WHERE  p.nombre = :nombre AND u.codigo = :vendedor AND p.disponible = true order by p.prioridad desc")
    Optional<Producto> buscarProductoPorNombreYVendedor(String nombre, int vendedor);

    @Transactional
    @Modifying
    @Query("UPDATE Producto p SET p.unidades = :unidades WHERE p.codigo = :codigoProducto")
    void actualizarUnidades(@Param("codigoProducto") int codigo, @Param("unidades") int unidades);

    @Transactional
    @Modifying
    @Query("UPDATE Producto p SET p.estado = :estado WHERE p.codigo = :codigo")
    void actualizarEstado(int codigo, EstadoProducto estado);

    @Transactional
    @Modifying
    @Query("UPDATE Producto p SET p.disponible = false WHERE p.codigo = :codigo")
    void deleteByCodigo(int codigo);

    @Query("SELECT p FROM Producto p JOIN p.favoritoUsuarios u WHERE u.codigo = :codigo order by p.prioridad desc")
    List<Producto> findProductoByFavoritoUsuarios(int codigo);




}
