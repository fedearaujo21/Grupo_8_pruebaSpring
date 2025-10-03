package grupo8.tecnoRAEE.model;

import lombok.Data;

@Data
public class Empresa {
    private Long id;
    private String razonSocial;
    private String cuit;
    private boolean estaAsociada;
    private String direccionCalle;
    private String direccionNumero;
    private String direccionBarrio;
    private String direccionCodPostal;
    private String horarioAtencion;

    // Relación lógica
    private Usuario usuario;
}
