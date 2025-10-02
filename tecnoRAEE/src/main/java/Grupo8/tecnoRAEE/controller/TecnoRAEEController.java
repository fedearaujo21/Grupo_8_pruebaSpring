package grupo8.tecnoRAEE.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        String htmlPath = "src/main/resources/static/index.html";
        return Files.readString(Paths.get(htmlPath));
    }


    
}
