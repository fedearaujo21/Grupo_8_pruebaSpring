package grupo8.tecnoRAEE.dao.impl;

import grupo8.tecnoRAEE.dao.InsertDAO;
import grupo8.tecnoRAEE.dao.ItemPedidoDao;
import grupo8.tecnoRAEE.model.ItemPedido;
import grupo8.tecnoRAEE.model.Residuo;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ItemPedidoImp extends InsertDAO implements ItemPedidoDao {

    private final Sql2o sql2o;

    public ItemPedidoImp(Sql2o sql2o) {
        super(sql2o);
        this.sql2o = sql2o;
    }


    @Override
    public List<ItemPedido> listarItemsPorPedido(Long pedidoId) throws Exception {
        String sql = "SELECT * FROM items_pedido WHERE pedido_recoleccion_id = :pedidoId;";

        try (Connection con = sql2o.open()) {
            List<Map<String, Object>> rows = con.createQuery(sql)
                    .addParameter("pedidoId", pedidoId)
                    .executeAndFetchTable()
                    .asList();

            List<ItemPedido> items = new ArrayList<>();

            for (Map<String, Object> row : rows) {
                ItemPedido item = new ItemPedido();

                // ============ CAMPOS PRINCIPALES ============
                Object idObj = row.get("id");
                if (idObj instanceof Number n) item.setId(n.longValue());

                Object cantidadObj = row.get("cantidad");
                if (cantidadObj instanceof Number n) item.setCantidad(n.intValue());

                Object pedidoObj = row.get("pedido_recoleccion_id");
                if (pedidoObj instanceof Number n) item.setPedido_recoleccion_id(n.longValue());

                // ============ RELACIÓN CON RESIDUO ============
                // Supongo que hay una columna "residuo_id" en la tabla items_pedido
                Object residuoObj = row.get("residuo_id");
                if (residuoObj instanceof Number n) {
                    Residuo residuo = new Residuo();
                    residuo.setId(n.longValue());
                    item.setResiduo(residuo);
                }

                items.add(item);
            }

            return items;

        } catch (Exception e) {
            System.err.println("❌ Error listando items de pedido: " + e.getMessage());
            throw new Exception("Error listando items de pedido", e);
        }
    }


    @Override
    public <T> Long insertar(T item) throws Exception {
        return super.insertar(item);
    }
}
