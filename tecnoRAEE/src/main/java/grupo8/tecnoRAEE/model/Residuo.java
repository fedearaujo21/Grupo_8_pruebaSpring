package grupo8.tecnoRAEE.model;

import lombok.Data;

@Data
public class Residuo {
    private Long id;
    private String nombre;
    private String codigo;
    private String descripcion;
    private boolean esValido;
}
