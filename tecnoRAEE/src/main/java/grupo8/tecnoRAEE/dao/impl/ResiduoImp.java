package grupo8.tecnoRAEE.dao.impl;

import grupo8.tecnoRAEE.dao.ResiduoDao;
import grupo8.tecnoRAEE.model.Residuo;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResiduoImp implements ResiduoDao {

    private final Sql2o sql2o;

    public ResiduoImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Residuo> listarValidos() throws Exception {
        String sql = "SELECT nombre, codigo" +
                "FROM residuos WHERE es_valido = 1;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Residuo.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error obteniendo residuos válidos", e);
        }
    }

    @Override
    public List<Residuo> getResiduos() {
        String sql = "SELECT id, nombre, codigo, descripcion, es_valido AS esValido " +
                "FROM residuos;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Residuo.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error obteniendo todos los residuos", e);
        }
    }

}
