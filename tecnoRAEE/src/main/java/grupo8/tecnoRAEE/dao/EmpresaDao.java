package grupo8.tecnoRAEE.dao;

import grupo8.tecnoRAEE.model.Empresa;
import java.util.List;

public interface EmpresaDao {
    List<Empresa> listarEmpresas() throws Exception;
    Empresa buscarPorId(Long id) throws Exception;
    void guardar(Empresa empresa) throws Exception;
}
