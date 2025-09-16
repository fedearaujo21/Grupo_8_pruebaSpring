package ar.edu.unlpam.ing.TP2.model.statistics;

import lombok.Getter;

@Getter
public class StatisticsResponse {
    private final float average;
    private final int min;
    private final int max;
    private final int amount;

    public StatisticsResponse(StatisticsData data){
        this.average=StatisticsService.average(data);
        this.max=StatisticsService.max(data);
        this.min=StatisticsService.min(data);
        this.amount=StatisticsService.amount(data);
    }
}
