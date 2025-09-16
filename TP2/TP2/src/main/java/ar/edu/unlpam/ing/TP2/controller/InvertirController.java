package ar.edu.unlpam.ing.TP2.controller;


import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlpam.ing.TP2.model.Invertir;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class InvertirController {
    @GetMapping("invertir/{cadena}")
    public Invertir invertir(@PathVariable ("cadena") String cadena) {
            return new Invertir(cadena);    
}
}