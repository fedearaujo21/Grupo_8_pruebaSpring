package grupo8.tecnoRAEE.controller;

import grupo8.tecnoRAEE.dto.PedidoRequestDTO;
import grupo8.tecnoRAEE.dto.PedidoResponseDTO;
import grupo8.tecnoRAEE.service.PedidoService;
import grupo8.tecnoRAEE.model.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;
    private static final Logger registraLog = LoggerFactory.getLogger(PedidoController.class);

    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody PedidoRequestDTO request) {
        try {
            PedidoResponseDTO response = pedidoService.crearPedido(request);
            registraLog.info("Pedido creado: {}", response);
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
            registraLog.info("Listando Pedidos");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            registraLog.info("Error al listar {}",e.getMessage());
            return ResponseEntity.internalServerError().body(e);
        }
    }
}
