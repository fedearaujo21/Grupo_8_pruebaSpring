package ar.edu.unlpam.ing.TP2.model;

import lombok.Getter;

@Getter
public class Invertir {
    private final String original;
    private final String invertida;
    public Invertir(String original){
        this.original=original;
        invertida= new StringBuilder(original).reverse().toString();
    }
}
