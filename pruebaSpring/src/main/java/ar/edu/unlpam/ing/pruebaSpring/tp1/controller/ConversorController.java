package ar.edu.unlpam.ing.pruebaSpring.tp1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConversorController {
    @GetMapping("/celsiusAfahrenheit/{celsius}")
    public Map<String, Object> convertir(@PathVariable double celsius){
        double fahrenheit = celsius * 9 / 5 + 32;
        return Map.of(
                "celsius", celsius,
                "fahrenheit", fahrenheit
        );
    }
}
