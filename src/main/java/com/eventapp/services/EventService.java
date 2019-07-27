package com.eventapp.services;

import com.eventapp.models.CommonEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class EventService {

    public List searchEvents(HashMap<String, Object> parameters) {

        List<CommonEvent> commonEventList = new ArrayList<>();
        commonEventList.add((CommonEvent) parameters.values());
        return commonEventList;
    }

    //wywołanie event source

}