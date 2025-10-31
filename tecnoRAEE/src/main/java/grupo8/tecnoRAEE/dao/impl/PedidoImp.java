package grupo8.tecnoRAEE.dao.impl;

import grupo8.tecnoRAEE.dao.PedidoDao;
import grupo8.tecnoRAEE.model.PedidoRecoleccion;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                List<Map<String, Object>> rows = con.createQuery(sql).executeAndFetchTable().asList();
                List<PedidoRecoleccion> pedidos = new ArrayList<>();

                for (Map<String, Object> row : rows) {
                    PedidoRecoleccion p = new PedidoRecoleccion();

                    Object idObj = row.get("id");
                    if (idObj instanceof Number n) p.setId(n.longValue());

                    Object userObj = row.get("usuario_id");
                    if (userObj instanceof Number n) p.setUsuario_id(n.longValue());

                    Object fechaObj = row.get("fecha");
                    if (fechaObj instanceof Timestamp ts) {
                        p.setFecha(ts);
                    } else if (fechaObj instanceof java.util.Date d) {
                        p.setFecha(new Timestamp(d.getTime()));
                    }

                    Object estadoObj = row.get("estado");
                    if (estadoObj != null) p.setEstado(estadoObj.toString());

                    Object calleObj = row.get("direccion_calle");
                    if (calleObj != null) p.setDireccionCalle(calleObj.toString());

                    Object numeroObj = row.get("direccion_numero");
                    if (numeroObj instanceof Number n) {
                        p.setDireccionNumero(String.valueOf(n.intValue()));
                    } else if (numeroObj != null) {
                        p.setDireccionNumero(numeroObj.toString());
                    }

                    Object barrioObj = row.get("direccion_barrio");
                    if (barrioObj != null) p.setDireccionBarrio(barrioObj.toString());

                    Object postalObj = row.get("direccion_cod_postal");
                    if (postalObj != null) p.setDireccionCodPostal(postalObj.toString());

                    pedidos.add(p);
                }
                return pedidos;
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
                    .addParameter("usuario_id", pedido.getUsuario_id())
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
