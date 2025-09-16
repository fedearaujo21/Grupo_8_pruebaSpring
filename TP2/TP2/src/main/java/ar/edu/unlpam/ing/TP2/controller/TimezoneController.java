package ar.edu.unlpam.ing.TP2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlpam.ing.TP2.model.TimeZone;


@RestController
public class TimezoneController {
    @GetMapping("/time")
    public TimeZone convertTimeZone(@RequestParam String date, @RequestParam String origin, @RequestParam String destination) {
        return new TimeZone(date,origin,destination);
    }
    
}
