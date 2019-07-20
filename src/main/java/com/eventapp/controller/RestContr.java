package com.eventapp.controller;

import com.eventapp.models.CommonEvent;
import com.eventapp.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<CommonEvent> findAll() {
        return eventService.findAll();
    }
    @GetMapping("findByName")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<CommonEvent> findByName(@RequestParam String name) {
        return Optional.ofNullable(eventService.findByName());
    }
    @GetMapping("/findByCity")
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<CommonEvent> findByCity(@RequestParam String city) {
        return eventService.findByCity();
    }
    @GetMapping("/findByCountry")
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<CommonEvent> findByCountry(@RequestParam String country) {
        return eventService.findByCountry();
    }
    @GetMapping("findByStartDate")
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<CommonEvent> findByStartDate(@RequestParam LocalDateTime startDate) {
        return eventService.findByStartDate();
    }
    @GetMapping("findByEndDate")
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<CommonEvent> findByStartDate(@RequestParam LocalDateTime endDate) {
        return eventService.findByEndDate();
    }
}
