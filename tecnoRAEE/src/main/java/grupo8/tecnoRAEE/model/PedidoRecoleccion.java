package grupo8.tecnoRAEE.model;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class PedidoRecoleccion {
    private Long id;
    private Date fecha;
    private String estado;

    private String direccionCalle;
    private String direccionNumero;
    private String direccionBarrio;
    private String direccionCodPostal;

    private Usuario usuario;
    private List<ItemPedido> items;
}
