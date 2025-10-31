package grupo8.tecnoRAEE.model;

import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

@Data
public class PedidoRecoleccion {
    private Long id;
    private Timestamp fecha;
    private String estado;

    private String direccionCalle;
    private String direccionNumero;
    private String direccionBarrio;
    private String direccionCodPostal;

    private Long usuario_id;
    private List<ItemPedido> items;
    }


