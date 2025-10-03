package grupo8.tecnoRAEE.dao;

import grupo8.tecnoRAEE.model.Usuario;
import java.util.List;

public interface UsuarioDao {
    List<Usuario> listarUsuarios() throws Exception;
    Usuario buscarPorId(Long id) throws Exception;
    Usuario buscarPorEmail(String email) throws Exception;
}
