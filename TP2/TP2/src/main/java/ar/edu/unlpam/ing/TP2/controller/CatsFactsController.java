package ar.edu.unlpam.ing.TP2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ar.edu.unlpam.ing.TP2.model.CatFacts;

@RestController
public class CatsFactsController {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/fact")
    public ResponseEntity<CatFacts> getRandomFact() {
        String url = "https://catfact.ninja/fact";
        ResponseEntity<CatFacts> response = restTemplate.getForEntity(url, CatFacts.class);
        return ResponseEntity.ok(response.getBody());
    }
}
