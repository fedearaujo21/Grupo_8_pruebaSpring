package ar.edu.unlpam.ing.TP2.model.statistics;

import java.util.Collections;





public class StatisticsService {
    

    static public float average(StatisticsData data){
        return data.getElements().stream().reduce(0, (a, b) -> a + b)/data.getElements().size();
    }

    static public int max(StatisticsData data){
        return Collections.max(data.getElements());
    }

    static public int min(StatisticsData data){
        return Collections.min(data.getElements());
    }

    static public int amount(StatisticsData data){
        return data.getElements().size();
    }
}
