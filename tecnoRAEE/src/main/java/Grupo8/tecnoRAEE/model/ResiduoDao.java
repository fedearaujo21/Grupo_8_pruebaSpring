package grupo8.tecnoRAEE.model;

import java.util.List;

public interface ResiduoDao {
    public List<Residuo> listarValidos() throws Exception;
    public List<Residuo> getResiduos();
}
