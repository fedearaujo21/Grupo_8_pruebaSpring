package grupo8.tecnoRAEE.dto;

import grupo8.tecnoRAEE.model.PedidoRecoleccion;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PedidoResponseDTO {
    private Long id;
    private Long usuarioId;
    private String estado;
    private Date fecha;
    private String direccionCalle;
    private String direccionNumero;
    private String direccionBarrio;
    private String direccionCodPostal;
    private List<ItemResponseDTO> items;

    public static PedidoResponseDTO fromEntity(PedidoRecoleccion pedido) {
        PedidoResponseDTO dto = new PedidoResponseDTO();
        dto.setId(pedido.getId());
        dto.setUsuarioId(pedido.getUsuario().getId());
        dto.setEstado(pedido.getEstado());
        dto.setFecha(pedido.getFecha());
        dto.setDireccionCalle(pedido.getDireccionCalle());
        dto.setDireccionNumero(pedido.getDireccionNumero());
        dto.setDireccionBarrio(pedido.getDireccionBarrio());
        dto.setDireccionCodPostal(pedido.getDireccionCodPostal());
        if (pedido.getItems() != null) {
            dto.setItems(
                    pedido.getItems().stream()
                            .map(ItemResponseDTO::fromEntity)
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }
}
