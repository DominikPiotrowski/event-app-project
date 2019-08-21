package com.eventapp.controller;

import com.eventapp.eventSources.eventBrite.SearchParams;
import com.eventapp.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class RestContr {

    private EventService eventService;

    @Autowired
    public RestContr(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/findEvent")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> findEvent(
            @RequestParam String eventName,
            @RequestParam LocalDateTime eventStartDate,
            @RequestParam LocalDateTime eventEndDate,
            @RequestParam String city,
            @RequestParam String country) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put(String.valueOf(SearchParams.EVENT_NAME), eventName);
        parameters.put(String.valueOf(SearchParams.EVENT_START_DATE), eventStartDate);
        parameters.put(String.valueOf(SearchParams.EVENT_END_DATE), eventEndDate);
        parameters.put(String.valueOf(SearchParams.CITY), city);
        parameters.put(String.valueOf(SearchParams.COUNTRY), country);

        return parameters;
    }
}