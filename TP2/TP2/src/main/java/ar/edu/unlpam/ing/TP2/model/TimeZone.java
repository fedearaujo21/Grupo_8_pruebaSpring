package ar.edu.unlpam.ing.TP2.model;

import lombok.Data;
import java.time.*;

@Data
public class TimeZone {
    private final String origin;
    private final String destination;
    public TimeZone(String date, String origin, String destination) {
        LocalDateTime ldate = LocalDateTime.parse(date);
        
        ZoneId originID= ZoneId.of(origin);

        ZonedDateTime originDate = ldate.atZone(originID);

        // Convertir a destino
        ZoneId destinationID = ZoneId.of(destination);
        ZonedDateTime destinationDate = originDate.withZoneSameInstant(destinationID);

        this.origin=date;
        this.destination=destinationDate.toString();
    }
}
