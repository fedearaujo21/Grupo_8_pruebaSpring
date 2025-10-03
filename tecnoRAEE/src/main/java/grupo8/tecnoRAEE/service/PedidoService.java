package grupo8.tecnoRAEE.service;

import grupo8.tecnoRAEE.dao.*;
import grupo8.tecnoRAEE.dto.*;
import grupo8.tecnoRAEE.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoDao pedidoDao;
    private final UsuarioDao usuarioDao;
    private final ResiduoDao residuoDao;
    private final ItemPedidoDao itemPedidoDao;

    public PedidoResponseDTO crearPedido(PedidoRequestDTO request) throws Exception {
        // 1. Buscar usuario
        Usuario usuario = usuarioDao.buscarPorId(request.getUsuarioId());
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        // 2. Crear pedido
        PedidoRecoleccion pedido = new PedidoRecoleccion();
        pedido.setUsuario(usuario);
        pedido.setFecha(new Date());
        pedido.setEstado("Pendiente de Asignación");
        pedido.setDireccionCalle(request.getDireccionCalle());
        pedido.setDireccionNumero(request.getDireccionNumero());
        pedido.setDireccionBarrio(request.getDireccionBarrio());
        pedido.setDireccionCodPostal(request.getDireccionCodPostal());

        // Guardar pedido en BD y setear id generado
        pedidoDao.guardar(pedido);

        // 3. Crear items
        List<ItemPedido> items = new ArrayList<>();
        for (ItemRequestDTO itemDTO : request.getItems()) {
            Residuo residuo = residuoDao.getResiduos().stream()
                    .filter(r -> r.getId().equals(itemDTO.getResiduoId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Residuo no encontrado"));

            if (!residuo.isEs_valido()) {
                throw new IllegalArgumentException("Residuo no válido: " + residuo.getNombre());
            }

            if (itemDTO.getCantidad() <= 0) {
                throw new IllegalArgumentException("Cantidad inválida");
            }

            ItemPedido item = new ItemPedido();
            item.setPedido(pedido);
            item.setResiduo(residuo);
            item.setCantidad(itemDTO.getCantidad());

            itemPedidoDao.guardar(item);
            items.add(item);
        }
        pedido.setItems(items);

        // 4. Devolver DTO de respuesta
        return PedidoResponseDTO.fromEntity(pedido);
    }
}
