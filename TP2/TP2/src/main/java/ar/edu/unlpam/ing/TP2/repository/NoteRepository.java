package ar.edu.unlpam.ing.TP2.repository;

import java.util.*;

import org.springframework.stereotype.Repository;
import ar.edu.unlpam.ing.TP2.model.Note;
import lombok.Data;

@Data
@Repository
public class NoteRepository {
    private List<Note> notes=new ArrayList<>();
    private int id=1;

        public int nextId() {
        return id++;
    }

        public void update(int id,Note data){
        Note note = notes.get(id);
        if(note.getTitle().isEmpty()){
            note.setContent(note.getContent());
        }
        else{note.setTitle(note.getTitle());}
    }

    public void add(Note data){
        notes.add(data);
    }

    public void remove(int id){
        notes.remove(id);
    }

    public Note read(int id){
        return notes.get(id);
    }
}
