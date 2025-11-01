package grupo8.tecnoRAEE.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void enviarCambioEstado(String destinatario, String estado) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject("Actualización de estado de tu pedido");
        mensaje.setText("Hola! El estado de tu pedido ha cambiado a: " + estado);
        mailSender.send(mensaje);
    }
}

