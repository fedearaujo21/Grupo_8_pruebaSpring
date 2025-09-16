package ar.edu.unlpam.ing.TP2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class GrettController {
@GetMapping("/")
public String greet(){
    return """
        <h1>Bienvenido a API-MANIA</h1>
        <div class="container">
        <a href="/celsiusAfahrenheit/1">1-/celsiusAfahrenheit/numero</a> 
        <a href="/esPrimo/1">2-/esPrimo/numero</a> 
        <a href="/invertir/hola">3-invertir/cadena</a> 
        <a href="/estadisticas">4-/estadisticas</a> 
        <a href="/books">5-/books</a> 
        <a href="/movies">6-/movies</a>    
        </div>
        <style>
            body {
              background-color: #62a576ff;
              font-family: Arial, sans-serif;
            }
            h1,a {
              color: #ffffffff;
              text-align: center;
              text-decoration: none;
              margin: 1em;
            }

            a:hover{
                font-weight: 800;
            }

            .container{
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            }
          </style>
        """;
}
}
