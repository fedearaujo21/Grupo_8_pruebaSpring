package grupo8.tecnoRAEE.controller;

import java.util.List;


import grupo8.tecnoRAEE.dto.*;
import grupo8.tecnoRAEE.service.ResiduoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResiduoController {

    private final ResiduoService service;
    private static final Logger registraLog = LoggerFactory.getLogger(ResiduoController.class);


    @GetMapping("/validos")
    public ResponseEntity<List<ResiduoDTO>> getResiduosValidos() {
        registraLog.info("Listando residuos validos");
        return service.listarResiduosValidos();
    }
}
