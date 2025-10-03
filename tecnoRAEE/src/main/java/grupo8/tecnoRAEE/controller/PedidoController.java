package grupo8.tecnoRAEE.controller;

import grupo8.tecnoRAEE.dto.PedidoRequestDTO;
import grupo8.tecnoRAEE.dto.PedidoResponseDTO;
import grupo8.tecnoRAEE.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody PedidoRequestDTO request) {
        try {
            PedidoResponseDTO response = pedidoService.crearPedido(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error creando pedido");
        }
    }
}
