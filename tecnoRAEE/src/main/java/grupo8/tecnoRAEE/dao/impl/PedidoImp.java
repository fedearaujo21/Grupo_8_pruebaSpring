package grupo8.tecnoRAEE.dao.impl;

import grupo8.tecnoRAEE.dao.InsertDAO;
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
public class PedidoImp extends InsertDAO implements PedidoDao {

    private final Sql2o sql2o;

    public PedidoImp(Sql2o sql2o) {
        super(sql2o);
        this.sql2o = sql2o;
    }

    @Override
    public List<PedidoRecoleccion> listarPedidos() throws Exception {
            String sql = "SELECT * FROM pedidos_recoleccion WHERE UPPER(estado) LIKE '%PENDIENTE%'";

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
            List<Map<String, Object>> rows = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchTable().asList();

            if (rows.isEmpty()) return null;

            Map<String, Object> row = rows.get(0);
            PedidoRecoleccion p = new PedidoRecoleccion();

            Object idObj = row.get("id");
            if (idObj instanceof Number n) p.setId(n.longValue());

            Object userObj = row.get("usuario_id");
            if (userObj instanceof Number n) p.setUsuario_id(n.longValue());

            Object fechaObj = row.get("fecha");
            if (fechaObj instanceof java.time.LocalDateTime ldt) {
                p.setFecha(java.sql.Timestamp.valueOf(ldt));
            } else if (fechaObj instanceof java.util.Date d) {
                p.setFecha(new java.sql.Timestamp(d.getTime()));
            }

            Object estadoObj = row.get("estado");
            if (estadoObj != null) p.setEstado(estadoObj.toString());

            Object calleObj = row.get("direccion_calle");
            if (calleObj != null) p.setDireccionCalle(calleObj.toString());

            Object numeroObj = row.get("direccion_numero");
            if (numeroObj != null) p.setDireccionNumero(numeroObj.toString());

            Object barrioObj = row.get("direccion_barrio");
            if (barrioObj != null) p.setDireccionBarrio(barrioObj.toString());

            Object postalObj = row.get("direccion_cod_postal");
            if (postalObj != null) p.setDireccionCodPostal(postalObj.toString());

            return p;
        } catch (Exception e) {
            throw new Exception("Error buscando pedido", e);
        }
    }

    public <T> Long insertar(T pedido) throws Exception {
        return super.insertar(pedido);
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

    @Override
    public void actualizarEstado(Long id, String nuevoEstado) throws Exception {
        String sql = "UPDATE pedidos_recoleccion SET estado = :estado WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("estado", nuevoEstado)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e){
            throw new Exception("Error actualizando estado del pedido", e);
        }
    }
}
