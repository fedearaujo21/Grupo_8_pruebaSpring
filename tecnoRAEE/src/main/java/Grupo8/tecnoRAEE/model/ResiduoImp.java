package grupo8.tecnoRAEE.model;


import java.util.List;

import org.sql2o.Connection;

public class ResiduoImp implements ResiduoDao {
    private final Sql2oDAO coneccion;

    public ResiduoImp(){
        coneccion= new Sql2oDAO();
    }

    @Override
    public List<Residuo> getResiduos(){
        
        
        return null;
    }

    @Override
    public List<Residuo> listarValidos(){
        List<Residuo> res;
        String sql = "Select * from producto;";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
        res = con
                .createQuery(sql)
                .executeAndFetch(Residuo.class);
        }
        return res;
    }        

}
