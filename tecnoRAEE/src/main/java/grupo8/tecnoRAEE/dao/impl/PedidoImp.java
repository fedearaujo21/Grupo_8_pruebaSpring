package grupo8.tecnoRAEE.dao.impl;

import grupo8.tecnoRAEE.dao.PedidoDao;
import grupo8.tecnoRAEE.model.PedidoRecoleccion;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoImp implements PedidoDao {

    private final Sql2o sql2o;

    public PedidoImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<PedidoRecoleccion> listarPedidos() throws Exception {
        String sql = "SELECT * FROM pedidos_recoleccion;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(PedidoRecoleccion.class);
        } catch (Exception e) {
            throw new Exception("Error listando pedidos", e);
        }
    }

    @Override
    public PedidoRecoleccion buscarPorId(Long id) throws Exception {
        String sql = "SELECT * FROM pedidos_recoleccion WHERE id = :id;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(PedidoRecoleccion.class);
        } catch (Exception e) {
            throw new Exception("Error buscando pedido", e);
        }
    }

    @Override
    public Long guardar(PedidoRecoleccion pedido) throws Exception {
        String sql = "INSERT INTO pedidos_recoleccion (usuario_id, fecha, estado, direccion_calle, direccion_numero, direccion_barrio, direccion_cod_postal) " +
                "VALUES (:usuario_id, :fecha, :estado, :direccion_calle, :direccion_numero, :direccion_barrio, :direccion_cod_postal)";
        try (Connection con = sql2o.open()) {
            Long pedidoid= con.createQuery(sql,true)
                    .addParameter("usuario_id", pedido.getUsuario().getId())
                    .addParameter("fecha", pedido.getFecha())
                    .addParameter("estado", pedido.getEstado())
                    .addParameter("direccion_calle", pedido.getDireccionCalle())
                    .addParameter("direccion_numero", pedido.getDireccionNumero())
                    .addParameter("direccion_barrio", pedido.getDireccionBarrio())
                    .addParameter("direccion_cod_postal", pedido.getDireccionCodPostal())
                    .executeUpdate()
                    .getKey(Long.class);
            return pedidoid;
        } catch (Exception e) {
            throw new Exception("Error guardando pedido", e);
        }
    }

    @Override
    public List<PedidoRecoleccion> listarPorUsuario(Long usuarioId) throws Exception {
        String sql = "SELECT * FROM pedidos_recoleccion WHERE usuario_id = :usuarioId;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("usuarioId", usuarioId)
                    .executeAndFetch(PedidoRecoleccion.class);
        } catch (Exception e) {
            throw new Exception("Error listando pedidos por usuario", e);
        }
    }
}
