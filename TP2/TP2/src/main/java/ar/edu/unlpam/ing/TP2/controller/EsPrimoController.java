package ar.edu.unlpam.ing.TP2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import ar.edu.unlpam.ing.TP2.model.EsPrimo;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class EsPrimoController {
@GetMapping("/esPrimo/{num}")
public EsPrimo verificar(@PathVariable ("num") int num) {
    return new EsPrimo(num);
}

}
