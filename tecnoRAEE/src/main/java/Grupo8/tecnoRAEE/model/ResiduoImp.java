package grupo8.tecnoRAEE.model;

import java.util.List;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

@Service
public class ResiduoImp implements ResiduoDao {


    @Override
    public List<Residuo> getResiduos() {

        return null;
    }

    @Override
    public List<Residuo> listarValidos() {
        List<Residuo> res;
        String sql = "Select * from residuos where es_valido=1;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            res = con
                    .createQuery(sql)
                    .executeAndFetch(Residuo.class);
        } catch (Exception e) {
            throw new InternalError();
        }
        return res;
    }

}
