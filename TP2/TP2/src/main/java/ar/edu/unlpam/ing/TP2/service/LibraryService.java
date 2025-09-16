package ar.edu.unlpam.ing.TP2.service;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.edu.unlpam.ing.TP2.model.Book;
import ar.edu.unlpam.ing.TP2.repository.LibraryRepository;


@Service
public class LibraryService {
    
    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository=libraryRepository;
    }

    //Book no repeat and no null
    public ResponseEntity<Book> add(Book data) {
        try {
            if (!libraryRepository.getBooks().contains(data)) {
            libraryRepository.add(data);
            return ResponseEntity.ok(data);
            }
            else{ return ResponseEntity.status(HttpStatus.CONFLICT).body(null); }
			
        } catch (Exception e) { return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);}
    }
    

    public ResponseEntity<Book> remove(int id){
        try {
            Book element = libraryRepository.read(id);
            libraryRepository.remove(id);
            return ResponseEntity.ok(element);
        } 
		catch (RuntimeException e) {  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}
    }
	
    public List<Book> read() {return libraryRepository.getBooks();}
    
    public ResponseEntity<Book> readElement(int id){
            try {
            libraryRepository.read(id);
            return ResponseEntity.ok(libraryRepository.getBooks().get(id));
        } 
            catch (RuntimeException e) { return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}
    }
}
