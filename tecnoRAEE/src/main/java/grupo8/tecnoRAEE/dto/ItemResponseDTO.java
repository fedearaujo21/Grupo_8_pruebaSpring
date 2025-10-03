package grupo8.tecnoRAEE.dto;

import grupo8.tecnoRAEE.model.ItemPedido;
import lombok.Data;

@Data
public class ItemResponseDTO {
    private String residuoNombre;
    private int cantidad;

    public static ItemResponseDTO fromEntity(ItemPedido item) {
        ItemResponseDTO dto = new ItemResponseDTO();
        dto.setResiduoNombre(item.getResiduo().getNombre());
        dto.setCantidad(item.getCantidad());
        return dto;
    }
}
