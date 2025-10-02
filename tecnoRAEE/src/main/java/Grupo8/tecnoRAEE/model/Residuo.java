package grupo8.tecnoRAEE.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Residuo {
    private Long id;
    private String nombre;
    private String codigo;
    private boolean es_valido;
    private String descripcion;

    public Residuo(){}
}
