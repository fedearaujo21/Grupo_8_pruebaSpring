package ar.edu.unlpam.ing.TP2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;
    private int publicationYear;

    public Book(){}
}
