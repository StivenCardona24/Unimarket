package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.DTO.UsuarioDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findUsuariosByCodigo(int codigo);

    @Query("SELECT u FROM Usuario u WHERE u.enumRole = :codigo")
    List<Usuario> findUsuariosByRoleCodigo(int codigo);
    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.enumRole = :codigo")
    long countUsuariosByRoleCodigo(int codigo);



    @Query("select u from Usuario u where u.cedula = :cedula")
    Usuario buscarUsuarioPorCedula1(String cedula);

    @Query("select u from Usuario u where u.cedula = :cedula")
    Optional<Usuario> buscarUsuarioPorCedula(String cedula);

    @Query("select u from Usuario u where u.email = :email")
    Usuario buscarUsuarioPorEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Usuario u SET u.codigoContrasenia  = :codigoContrasenia WHERE u.codigo = :codigo")
    void actualizarCodigoContrasenia(@Param("codigo") int codigo, @Param("codigoContrasenia") String codigoContrasenia);

    @Transactional
    @Modifying
    @Query("UPDATE Usuario u SET u.password  = :password WHERE u.codigo = :codigo")
    void actualizarContrasenia(@Param("codigo") int codigo, @Param("password") String password);


    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByEmailAndEnumRole(String email, String role);

    Optional<Usuario> findByCodigo(int codigo);

/*

    @Query("Saelect aliasTabla From tabla aliasTabla where tabla.field=;param")
    Usuario buscarUSuarioCorreo(String param);

    Plantilla infiera query desde java
    findby
    */
}
