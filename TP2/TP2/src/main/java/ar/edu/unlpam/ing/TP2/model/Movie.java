package ar.edu.unlpam.ing.TP2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
    private int id;
    private String title;
    private String director;
    private int year;
    private String genre;

    public Movie(){}
}
