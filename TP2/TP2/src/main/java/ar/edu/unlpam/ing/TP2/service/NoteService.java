package ar.edu.unlpam.ing.TP2.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.edu.unlpam.ing.TP2.model.Note;
import ar.edu.unlpam.ing.TP2.repository.NoteRepository;

@Service
public class NoteService {
    
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository){
        this.noteRepository=noteRepository;
    }


    public ResponseEntity<Note> add(Note data){
            
        try {
            if (!noteRepository.getNotes().contains(data)) {
            data.setId(noteRepository.nextId());
            noteRepository.add(data);
            return ResponseEntity.ok(data);
            }
            else{ return ResponseEntity.status(HttpStatus.CONFLICT).body(null);}
        } 
        catch (Exception e) {return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);}
    }

    public ResponseEntity<Note> remove(int id){
        try {
            Note element= noteRepository.read(id);
            noteRepository.remove(id);
            return ResponseEntity.ok(element);
        } 
        catch (RuntimeException e) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}
    }

    public List<Note> read(){
        return noteRepository.getNotes();
    }

    //modify empty attribute or not found
    public ResponseEntity<Note> modify(int id, Note note){
    try {
        noteRepository.update(id,note);
        return ResponseEntity.ok(noteRepository.read(id));
        }
        
        catch (RuntimeException e) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}
    }
}
