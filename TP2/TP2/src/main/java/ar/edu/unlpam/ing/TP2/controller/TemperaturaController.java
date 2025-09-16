package ar.edu.unlpam.ing.TP2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlpam.ing.TP2.model.Temperatura;



@RestController
public class TemperaturaController {
@GetMapping("/celsiusAfahrenheit/{celsius}")
public Temperatura convertir(@PathVariable("celsius") double celsius){
    return new Temperatura(celsius);
}

}