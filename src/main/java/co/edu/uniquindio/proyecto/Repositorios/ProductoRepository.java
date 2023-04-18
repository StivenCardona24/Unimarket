package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    List<Producto> findProductoByFavoritoUsuarios(int codigo);
}
