package ar.edu.unlpam.ing.TP2.model;

import lombok.Getter;


@Getter
public class Temperatura {
    private final double celsius;
    private final double fahrenheit;
    public Temperatura(double celsius){
        this.celsius = celsius;
        this.fahrenheit = convaFahrenheit();
    }
    private double convaFahrenheit(){
        return (celsius * 9 / 5) + 32;
    }
}
