package grupo8.tecnoRAEE.dao.impl;

import grupo8.tecnoRAEE.dao.EmpresaDao;
import grupo8.tecnoRAEE.model.Empresa;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpresaImp implements EmpresaDao {

    private final Sql2o sql2o;

    public EmpresaImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Empresa> listarEmpresas() throws Exception {
        String sql = "SELECT * FROM empresas;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Empresa.class);
        } catch (Exception e) {
            throw new Exception("Error listando empresas", e);
        }
    }

    @Override
    public Empresa buscarPorId(Long id) throws Exception {
        String sql = "SELECT * FROM empresas WHERE id = :id;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Empresa.class);
        } catch (Exception e) {
            throw new Exception("Error buscando empresa", e);
        }
    }

    @Override
    public void guardar(Empresa empresa) throws Exception {
        String sql = "INSERT INTO empresas (usuario_id, razon_social, cuit, esta_asociada, direccion_calle, direccion_numero, direccion_barrio, direccion_cod_postal, horario_atencion) " +
                "VALUES (:usuarioId, :razonSocial, :cuit, :estaAsociada, :direccionCalle, :direccionNumero, :direccionBarrio, :direccionCodPostal, :horarioAtencion)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("usuarioId", empresa.getUsuario().getId())
                    .addParameter("razonSocial", empresa.getRazonSocial())
                    .addParameter("cuit", empresa.getCuit())
                    .addParameter("estaAsociada", empresa.isEstaAsociada())
                    .addParameter("direccionCalle", empresa.getDireccionCalle())
                    .addParameter("direccionNumero", empresa.getDireccionNumero())
                    .addParameter("direccionBarrio", empresa.getDireccionBarrio())
                    .addParameter("direccionCodPostal", empresa.getDireccionCodPostal())
                    .addParameter("horarioAtencion", empresa.getHorarioAtencion())
                    .executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error guardando empresa", e);
        }
    }
}
