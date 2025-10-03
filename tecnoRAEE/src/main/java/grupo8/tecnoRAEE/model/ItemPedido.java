package grupo8.tecnoRAEE.model;

import lombok.Data;

@Data
public class ItemPedido {
    private Long id;
    private int cantidad;
    private Residuo residuo;
    private PedidoRecoleccion pedido;
}
