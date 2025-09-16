package ar.edu.unlpam.ing.TP2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import ar.edu.unlpam.ing.TP2.model.Dolar;

@RestController

public class DolarController {
    private final RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/cotizacion")
    public ResponseEntity<Dolar> getDolarPrice() {
        String url = "https://dolarapi.com/v1/dolares/oficial";
        ResponseEntity<Dolar> response = restTemplate.getForEntity(url, Dolar.class);
        return ResponseEntity.ok(response.getBody());
    }
}
