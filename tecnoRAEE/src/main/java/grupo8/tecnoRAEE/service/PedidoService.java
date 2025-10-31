package grupo8.tecnoRAEE.service;

import grupo8.tecnoRAEE.dao.*;
import grupo8.tecnoRAEE.dto.*;
import grupo8.tecnoRAEE.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        pedido.setUsuario_id(usuario.getId());
        pedido.setFecha(Timestamp.valueOf(LocalDateTime.now()));
        pedido.setEstado("Pendiente de Asignación");
        pedido.setDireccionCalle(request.getDireccionCalle());
        pedido.setDireccionNumero(request.getDireccionNumero());
        pedido.setDireccionBarrio(request.getDireccionBarrio());
        pedido.setDireccionCodPostal(request.getDireccionCodPostal());

        // Guardar pedido en BD y devolvemos el id del pedido
        Long pedidoid = pedidoDao.guardar(pedido);

        //seteamos el id generado para cargar en el item
        pedido.setId(pedidoid);

        // 3. Crear items
        List<ItemPedido> items = new ArrayList<>();
        for (ItemRequestDTO itemDTO : request.getItems()) {
            Residuo residuo = residuoDao.findById(itemDTO.getResiduoId());
            if(residuo == null){
                throw new IllegalArgumentException("Residuo no encontrado con ID: " + itemDTO.getResiduoId());
            }

            if (!residuo.isEs_valido()) {
                throw new IllegalArgumentException("Residuo no válido: " + residuo.getNombre());
            }

            if (itemDTO.getCantidad() <= 0) {
                throw new IllegalArgumentException("Cantidad inválida");
            }

            ItemPedido item = new ItemPedido();
            System.out.println("el id es " +pedidoid);
            item.setPedido_recoleccion_id(pedidoid);
            item.setResiduo(residuo);
            item.setCantidad(itemDTO.getCantidad());

            itemPedidoDao.guardar(item);
            items.add(item);
        }
        pedido.setItems(items);

        // 4. Devolver DTO de respuesta
        return PedidoResponseDTO.fromEntity(pedido);
    }

    public List<PedidoRecoleccion> listarPedidos() throws Exception{
        List<PedidoRecoleccion> pedidos = pedidoDao.listarPedidos();
        for (PedidoRecoleccion pedido : pedidos) {
            List<ItemPedido> items = itemPedidoDao.listarItemsPorPedido(pedido.getId());
            for(ItemPedido item: items){
                Residuo residuo = residuoDao.findById(item.getResiduo().getId());
                item.setResiduo(residuo);
            }
            pedido.setItems(items);
        }
        return pedidos;
    }


}
