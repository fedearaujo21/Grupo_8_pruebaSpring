package ar.edu.unlpam.ing.TP2.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.unlpam.ing.TP2.model.Note;
import ar.edu.unlpam.ing.TP2.service.NoteService;

@RestController
public class NoteController {
    
    private final NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService=noteService;
    }

    @GetMapping("/notes")
    public List<Note> read() {
        return noteService.read();
}

@PutMapping("/notes/{id}")
    public ResponseEntity<Note> modify(@PathVariable ("id") int id, @RequestBody Note data) {
        return noteService.modify(id, data);
}

@PostMapping("/notes")
    public ResponseEntity<Note> add(@RequestBody Note data) {
        return noteService.add(data);
}

@DeleteMapping("/notes/{id}")
    public ResponseEntity<Note> remove(@PathVariable ("id") int id) {
        return noteService.remove(id);
}

}
