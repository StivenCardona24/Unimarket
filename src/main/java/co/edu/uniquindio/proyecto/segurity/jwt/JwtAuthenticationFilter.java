package co.edu.uniquindio.proyecto.segurity.jwt;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
@Component
public class JwtAuthenticationFilter implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, @NotNull HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        MensajeDTO dto = new MensajeDTO(HttpStatus.UNAUTHORIZED, true, "Token no encontrado o inválido");
        response.setContentType("application/json");
        response.setStatus(dto.getEstado().value());
        response.getWriter().write(new ObjectMapper().writeValueAsString(dto));
        response.getWriter().flush();
        response.getWriter().close();
    }
}