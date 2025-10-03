package grupo8.tecnoRAEE.dao.impl;

import grupo8.tecnoRAEE.dao.UsuarioDao;
import grupo8.tecnoRAEE.model.Usuario;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioImp implements UsuarioDao {

    private final Sql2o sql2o;

    public UsuarioImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Usuario> listarUsuarios() throws Exception {
        String sql = "SELECT * FROM usuarios;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Usuario.class);
        } catch (Exception e) {
            throw new Exception("Error listando usuarios", e);
        }
    }

    @Override
    public Usuario buscarPorId(Long id) throws Exception {
        String sql = "SELECT * FROM usuarios WHERE id = :id;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Usuario.class);
        } catch (Exception e) {
            throw new Exception("Error buscando usuario por id", e);
        }
    }

    @Override
    public Usuario buscarPorEmail(String email) throws Exception {
        String sql = "SELECT * FROM usuarios WHERE email = :email;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("email", email)
                    .executeAndFetchFirst(Usuario.class);
        } catch (Exception e) {
            throw new Exception("Error buscando usuario por email", e);
        }
    }
}
