package ar.edu.unlpam.ing.TP2.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Dolar {
    private final float buy;
    private final float sell;
    private final String house;
    private final String name;
    private final String coin;
    private final String updateDate;

}
