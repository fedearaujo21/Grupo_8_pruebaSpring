package grupo8.tecnoRAEE.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import grupo8.tecnoRAEE.model.ResiduoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import grupo8.tecnoRAEE.model.ResiduoService;

@Controller
public class TecnoRAEEController {
    
    private final ResiduoService service;

    public TecnoRAEEController(ResiduoService service){
        this.service=service;
    }
    
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/validos")
    public ResponseEntity<List<ResiduoDTO>> getResiduosValidos(){
        return service.listarResiduosValidos();
    }
    
}
