package grupo8.tecnoRAEE.dto;

import lombok.Data;
import java.util.List;

@Data
public class PedidoRequestDTO {
    private Long usuarioId;
    private String direccionCalle;
    private String direccionNumero;
    private String direccionBarrio;
    private String direccionCodPostal;
    private List<ItemRequestDTO> items;
}
