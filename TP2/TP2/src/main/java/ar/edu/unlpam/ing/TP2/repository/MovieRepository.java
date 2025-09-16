package ar.edu.unlpam.ing.TP2.repository;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import ar.edu.unlpam.ing.TP2.model.Movie;
import lombok.Data;

@Repository
@Data
public class MovieRepository {
    private List<Movie> movies = new ArrayList<>();


    public Movie read(int id){
        return movies.get(id);
    }

    public Movie read(String title){
        for (Movie element : movies) {
            if (element.getTitle().equals(title)) {
                return element;
            }
        }
        return null;
    }

    public void add(Movie data){
        movies.add(data);
    }

    public void remove(int id){
        movies.remove(id);
    }
}
