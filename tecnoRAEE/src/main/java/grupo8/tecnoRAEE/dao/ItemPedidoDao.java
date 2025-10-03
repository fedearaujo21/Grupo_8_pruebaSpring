package grupo8.tecnoRAEE.dao;

import grupo8.tecnoRAEE.model.ItemPedido;
import java.util.List;

public interface ItemPedidoDao {
    List<ItemPedido> listarItemsPorPedido(Long pedidoId) throws Exception;
    void guardar(ItemPedido item) throws Exception;
}
