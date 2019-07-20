package com.eventapp.controller;

import com.eventapp.models.CommonEvent;
import com.eventapp.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("")
public class RestContr {

    //TODO --tutaj zasoby z endopointami, metody do nich

    private EventService eventService;

    @Autowired
    public RestContr(EventService eventService) {
        this.eventService = eventService;
    }

    @EventListener(ApplicationReadyEvent.class)
    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<CommonEvent> findAll() {
        return (Iterable<CommonEvent>) eventService.findAll();
    }
    @GetMapping("findByName")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<CommonEvent> findByName(@RequestParam String name) {
        return Optional.ofNullable(eventService.findByName(name));
    }
    @GetMapping("/findByCity")
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<CommonEvent> findByCity(@RequestParam String city) {
        return eventService.findByCity(city);
    }
    @GetMapping("/findByCountry")
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<CommonEvent> findByCountry(@RequestParam String country) {
        return eventService.findByCountry(country);
    }
    @GetMapping("findByStartDate")
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<CommonEvent> findByStartDate(@RequestParam LocalDateTime startDate) {
        return eventService.findByStartDate(startDate);
    }
    @GetMapping("findByEndDate")
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<CommonEvent> findByEndDate(@RequestParam LocalDateTime endDate) {
        return eventService.findByEndDate(endDate);
    }
}
