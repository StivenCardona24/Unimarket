package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
/*
    @Query("Saelect aliasTabla From tabla aliasTabla where tabla.field=;param")
    Usuario buscarUSuarioCorreo(String param);

    Plantilla infiera query desde java
    findby
    */
}
