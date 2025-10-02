package grupo8.tecnoRAEE.dao;

import grupo8.tecnoRAEE.model.Residuo;

import java.util.List;

public interface ResiduoDao {
    public List<Residuo> listarValidos() throws Exception;
    public List<Residuo> getResiduos();
}
