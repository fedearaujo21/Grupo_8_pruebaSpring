package Grupo8.tecnoRAEE.dto;

import java.util.List;

import Grupo8.tecnoRAEE.dao.ResiduoDao;
import Grupo8.tecnoRAEE.dao.Sql2oDAO;
import Grupo8.tecnoRAEE.model.Residuo;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

@Service
public class ResiduoImp implements ResiduoDao {


    @Override
    public List<Residuo> getResiduos() {

        return null;
    }

    @Override
    public List<Residuo> listarValidos() throws RuntimeException, ResiduoDAOException {
        List<Residuo> res;
        String sql = "Select * from residuos where es_valido=1;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            res = con
                    .createQuery(sql)
                    .executeAndFetch(Residuo.class);
            return res;
        } catch (Exception e) {
            throw new InternalError("Error de conexion", e);
        }
    }
}
