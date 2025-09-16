package ar.edu.unlpam.ing.TP2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ar.edu.unlpam.ing.TP2.model.statistics.*;




@RestController
public class StatisticsController {
@PostMapping("/estadisticas")
public StatisticsResponse Statistics(@RequestBody StatisticsData numbers) {
    return new StatisticsResponse(numbers);
}    
}
