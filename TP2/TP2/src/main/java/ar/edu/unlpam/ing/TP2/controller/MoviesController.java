package ar.edu.unlpam.ing.TP2.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import ar.edu.unlpam.ing.TP2.model.Movie;
import ar.edu.unlpam.ing.TP2.service.MovieService;

@RestController
public class MoviesController {
        private final MovieService moviesService;

    public MoviesController(MovieService moviesService){
        this.moviesService=moviesService;
    }

@GetMapping("/movies")
    public List<Movie> read() {
        return moviesService.read();
}


@GetMapping("/movies/{title}")
    public ResponseEntity<Movie> read(@RequestParam ("title") String title) {
        return moviesService.read(title);
}


@PostMapping("/movies")
    public ResponseEntity<Movie> add(@RequestBody Movie data) {
        return moviesService.add(data);
}

@DeleteMapping("/movies/{id}")
    public ResponseEntity<Movie> remove(@PathVariable ("id") int id) {
        return moviesService.remove(id);
}
}
