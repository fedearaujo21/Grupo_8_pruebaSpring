package ar.edu.unlpam.ing.TP2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlpam.ing.TP2.model.Book;
import ar.edu.unlpam.ing.TP2.service.LibraryService;

@RestController
public class LibraryController {
        private final LibraryService libraryService;

        public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
        }


@GetMapping("/books")
    public List<Book> read() {
        return libraryService.read();
}

@GetMapping("/books/{id}")
    public ResponseEntity<Book> read(@PathVariable ("id") int id) {       
        return libraryService.readElement(id);
}

@PostMapping("/books")
    public ResponseEntity<Book> add(@RequestBody Book data) {
        return libraryService.add(data);
}

@DeleteMapping("/books/{id}")
    public ResponseEntity<Book> remove(@PathVariable ("id") int id) {
        return  libraryService.remove(id);
    }

}
