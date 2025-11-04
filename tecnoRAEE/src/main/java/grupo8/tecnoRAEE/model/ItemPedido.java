package grupo8.tecnoRAEE.model;

import lombok.Data;

@Data
@Tabla(nombre = "items_pedido")
public class ItemPedido {
    private Long id;
    private int cantidad;
    private Residuo residuo;
    private Long pedido_recoleccion_id;
}
