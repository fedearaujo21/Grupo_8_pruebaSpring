package grupo8.tecnoRAEE.controller;

import java.util.List;


import grupo8.tecnoRAEE.dto.*;
import grupo8.tecnoRAEE.service.ResiduoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ResiduoController {

    private final ResiduoService service;

    public ResiduoController(ResiduoService service){
        this.service = service;
    }

    @GetMapping("/validos")
    public ResponseEntity<List<ResiduoDTO>> getResiduosValidos() {
        return service.listarResiduosValidos();
    }
}
