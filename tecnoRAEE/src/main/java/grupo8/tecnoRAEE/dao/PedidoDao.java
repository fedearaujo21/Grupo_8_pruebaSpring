package grupo8.tecnoRAEE.dao;

import grupo8.tecnoRAEE.model.PedidoRecoleccion;
import java.util.List;

public interface PedidoDao {
    List<PedidoRecoleccion> listarPedidos() throws Exception;
    PedidoRecoleccion buscarPorId(Long id) throws Exception;
    Long guardar(PedidoRecoleccion pedido) throws Exception;
    List<PedidoRecoleccion> listarPorUsuario(Long usuarioId) throws Exception;
}
