package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Query("SELECT r FROM Role r")
    List<Role> findAllRoles();

    @Query("SELECT r FROM Role r WHERE r.codigo = :codigo")
    Role findRoleByCodigo(int codigo);

    @Query("SELECT r FROM Role r ORDER BY r.nombre ASC")
    List<Role> findAllRolesOrderByNombreAsc();
    @Query("SELECT r FROM Role r WHERE r.nombre LIKE concat ( '%', :nombre, '%' ) ORDER BY r.nombre ASC")
    List<Role> findRolesByNombreStartingWith(String nombre);
    @Query("SELECT r FROM Role r WHERE r.usuarios IS NOT EMPTY")
    List<Role> findRolesWithUsuarios();
    @Query("SELECT r FROM Role r WHERE r.usuarios IS EMPTY")
    List<Role> findRolesWithoutUsuarios();
}
