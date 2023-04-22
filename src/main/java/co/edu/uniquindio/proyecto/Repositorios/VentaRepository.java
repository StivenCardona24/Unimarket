package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Venta;

import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Integer> {
    @Query("SELECT c FROM Venta c WHERE c.usuario.codigo = :idUsuario")
    List<Venta> findByUsuarioIdUsuario(int idUsuario);


}
