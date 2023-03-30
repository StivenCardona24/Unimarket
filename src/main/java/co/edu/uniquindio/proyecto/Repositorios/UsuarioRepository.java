package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.role.codigo = :codigo")
    List<Usuario> findUsuariosByRoleCodigo(int codigo);
    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.role.codigo = :codigo")
    long countUsuariosByRoleCodigo(int codigo);

/*
    @Query("Saelect aliasTabla From tabla aliasTabla where tabla.field=;param")
    Usuario buscarUSuarioCorreo(String param);

    Plantilla infiera query desde java
    findby
    */
}
