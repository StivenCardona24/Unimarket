package co.edu.uniquindio.proyecto.seguridad.modelo;

import co.edu.uniquindio.proyecto.Modelo.Clases.Usuario;
import co.edu.uniquindio.proyecto.Modelo.Enumeraciones.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@AllArgsConstructor
@Getter
public class UserDetailsImpl implements UserDetails {
    private String username, password;
    private int codigo;
    private Collection<? extends GrantedAuthority> authorities;
    public static UserDetailsImpl build(Usuario user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println(user.getEnumRole());
        if(user.getEnumRole() == Role.CLIENTE){
            authorities.add( new SimpleGrantedAuthority("CLIENTE") );
        }else if(user.getEnumRole() == Role.MODERADOR){
            authorities.add( new SimpleGrantedAuthority("MODERADOR") );
        }
        return new UserDetailsImpl(user.getEmail(), user.getPassword(), user.getCodigo(), authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}