package ar.edu.unlpam.ing.TP2.repository;

import java.util.*;

import org.springframework.stereotype.Repository;
import ar.edu.unlpam.ing.TP2.model.Book;
import lombok.Data;

@Repository
@Data
public class LibraryRepository {
    private final List<Book> books = new ArrayList<>();

    public Book read(int id){
        return books.get(id);
    }

    public void add(Book data){
        books.add(data);
    }

    public void remove(int id){
        books.remove(id);
    }
}
