package grupo8.tecnoRAEE.dto;

import java.util.List;

import grupo8.tecnoRAEE.dao.*;
import grupo8.tecnoRAEE.model.*;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

@Service
public class ResiduoImp implements ResiduoDao {


    @Override
    public List<Residuo> getResiduos() {

        return null;
    }

    @Override
    public List<Residuo> listarValidos(){
        List<Residuo> res;
        String sql = "Select * from residuos where es_valido=1;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            res = con
                    .createQuery(sql)
                    .executeAndFetch(Residuo.class);
            return res;
        }
    }
}
