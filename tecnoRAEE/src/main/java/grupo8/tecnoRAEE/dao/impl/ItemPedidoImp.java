package grupo8.tecnoRAEE.dao.impl;

import grupo8.tecnoRAEE.dao.ItemPedidoDao;
import grupo8.tecnoRAEE.model.ItemPedido;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemPedidoImp implements ItemPedidoDao {

    private final Sql2o sql2o;

    public ItemPedidoImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<ItemPedido> listarItemsPorPedido(Long pedidoId) throws Exception {
        String sql = "SELECT * FROM items_pedido WHERE pedido_recoleccion_id = :pedidoId;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(ItemPedido.class);
        } catch (Exception e) {
            throw new Exception("Error listando items de pedido", e);
        }
    }

    @Override
    public void guardar(ItemPedido item) throws Exception {
        String sql = "INSERT INTO items_pedido (pedido_recoleccion_id, residuo_id, cantidad) " +
                "VALUES (:pedidoId, :residuoId, :cantidad)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("pedidoId", item.getPedidoId())
                    .addParameter("residuoId", item.getResiduo().getId())
                    .addParameter("cantidad", item.getCantidad())
                    .executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error guardando item de pedido", e);
        }
    }
}
