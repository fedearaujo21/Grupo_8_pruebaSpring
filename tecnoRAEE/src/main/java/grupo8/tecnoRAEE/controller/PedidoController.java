package grupo8.tecnoRAEE.controller;

import grupo8.tecnoRAEE.dto.PedidoRequestDTO;
import grupo8.tecnoRAEE.dto.PedidoResponseDTO;
import grupo8.tecnoRAEE.service.PedidoService;
import grupo8.tecnoRAEE.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/listar")
    public ResponseEntity<?> listarPedidos() {
        try {
            List<PedidoRecoleccion> response = pedidoService.listarPedidos();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }
}
