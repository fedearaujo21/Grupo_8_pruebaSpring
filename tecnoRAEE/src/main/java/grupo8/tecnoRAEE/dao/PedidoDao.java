package grupo8.tecnoRAEE.dao;

import grupo8.tecnoRAEE.model.PedidoRecoleccion;
import java.util.List;

public interface PedidoDao {
    List<PedidoRecoleccion> listarPedidos() throws Exception;
    PedidoRecoleccion buscarPorId(Long id) throws Exception;
    <T> Long insertar_key(T pedido) throws Exception;
    List<PedidoRecoleccion> listarPorUsuario(Long usuarioId) throws Exception;
    void actualizarEstado(Long id, String nuevoEstado) throws Exception;
}
