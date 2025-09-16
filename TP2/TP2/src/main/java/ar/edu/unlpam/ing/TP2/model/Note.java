package ar.edu.unlpam.ing.TP2.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Note {
    private long  id;
    private String content;
    private String title;
    private Date creationDate;

    public Note(){}
}
