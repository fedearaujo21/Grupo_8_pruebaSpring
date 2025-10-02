package grupo8.tecnoRAEE.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import grupo8.tecnoRAEE.model.ResiduoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import grupo8.tecnoRAEE.model.ResiduoService;

@RestController
public class TecnoRAEEController {
    
    private final ResiduoService service;

    public TecnoRAEEController(ResiduoService service){
        this.service=service;
    }
    
    @GetMapping("/")
    public String home() throws IOException{
        String htmlPath = "src/main/resources/templates/index.html";
        return Files.readString(Paths.get(htmlPath));
    }

    @GetMapping("/valid")
    public ResponseEntity<List<ResiduoDTO>> getResiduosValidos(){
        return service.listarResiduosValidos();
    }
    
}
