package grupo8.tecnoRAEE.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import grupo8.tecnoRAEE.dto.*;
import grupo8.tecnoRAEE.service.ResiduoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class TecnoRAEEController {

    private final ResiduoService service;

    public TecnoRAEEController(ResiduoService service){
        System.out.println(">>> TecnoRAEEController inicializado <<<");
        this.service = service;
    }

    @GetMapping("/validos")
    public ResponseEntity<List<ResiduoDTO>> getResiduosValidos() {
        System.out.println(">>> Entrando a /api/validos <<<");
        return service.listarResiduosValidos();
    }
}
