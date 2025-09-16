package ar.edu.unlpam.ing.TP2.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.edu.unlpam.ing.TP2.model.Movie;
import ar.edu.unlpam.ing.TP2.repository.MovieRepository;

@Service
public class MovieService {
    
    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

        public List<Movie> read(){
        return movieRepository.getMovies();
    }

    public ResponseEntity<Movie> read(String title){
        Movie element = movieRepository.read(title);
        if(element == null){
            return ResponseEntity.ok(element);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

        //libros no repetidos y no nulos
    public ResponseEntity<Movie> add(Movie data){
        try {
            if (!movieRepository.getMovies().contains(data)) {
            movieRepository.add(data);
            return ResponseEntity.ok(data);
        }
        else{ return ResponseEntity.status(HttpStatus.CONFLICT).body(null);}

        } catch (Exception e) { return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);}
    }

    public ResponseEntity<Movie> remove(int id){    
        try {
            Movie element = movieRepository.read(id);
            movieRepository.remove(id);
            return ResponseEntity.ok(element);
        } 
        catch (RuntimeException e) { return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}
    }

    //Cotains element with ID X ?
    public boolean contains(long id){
        for (Movie element : movieRepository.getMovies()) {
            if (element.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
