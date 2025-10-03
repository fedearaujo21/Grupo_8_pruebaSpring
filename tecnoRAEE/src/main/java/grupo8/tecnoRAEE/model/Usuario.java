package grupo8.tecnoRAEE.model;

import lombok.Data;
import java.util.Date;

@Data
public class Usuario {
    private Long id;
    private String email;
    private String password;
    private String tipo;
    private Date fecha_creacion;
}
