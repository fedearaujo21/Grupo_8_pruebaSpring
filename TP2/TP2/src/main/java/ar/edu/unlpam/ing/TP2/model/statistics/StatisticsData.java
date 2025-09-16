package ar.edu.unlpam.ing.TP2.model.statistics;


import java.util.*;
import lombok.Data;

@Data
public class StatisticsData{ 
    private List<Integer> numbers = new ArrayList<>();


    public List<Integer> getElements() {
        return numbers;
    }

    public void setElements(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
