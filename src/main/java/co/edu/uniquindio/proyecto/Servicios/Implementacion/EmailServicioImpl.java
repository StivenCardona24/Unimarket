package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.DTO.EmailDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class EmailServicioImpl implements EmailServicio {
    private final JavaMailSender javaMailSender;
    // donde se manden emails
    // emailServicio.enviarEmail(new EmailDTO("Asunto", "Cuerpo mensaje", "Correo destino"));
    @Override
    public void enviarEmail(EmailDTO emailDTO) throws Exception {
            MimeMessage mensaje = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensaje);
            try{
                helper.setSubject(emailDTO.getAsunto());
                helper.setText(emailDTO.getCuerpo(), true);
                helper.setTo(emailDTO.getDestinatario());
                helper.setFrom("no_reply@dominio.com");
                javaMailSender.send(mensaje);
            }catch (Exception e){
                e.printStackTrace();
            }
    }

}
