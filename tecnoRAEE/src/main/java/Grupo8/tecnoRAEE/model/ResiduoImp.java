package grupo8.tecnoRAEE.model;

import java.util.List;

public class ResiduoImp implements ResiduoDao {
    private final Sql2oDAO coneccion;

    public ResiduoImp(){
        coneccion= new Sql2oDAO();
    }

    public List<Residuo> getResiduos(){
        return null;
    }
}
