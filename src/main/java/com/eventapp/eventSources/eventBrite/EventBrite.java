package com.eventapp.eventSources.eventBrite;

import com.eventapp.client.EventSource;
import com.eventapp.eventSources.eventBrite.model.EventBriteEvent;
import com.eventapp.eventSources.eventBrite.model.Events;
import com.eventapp.models.CommonEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class EventBrite implements EventSource {
    @Override
    public CommonEvent getEventData() {
        Events events = new Events();
        return mapEventBriteEventToCommonEvent(events);
    }

    public List<EventBriteEvent> getEventList() {
        List<EventBriteEvent> result = new ArrayList<>();
        result.add(new EventBriteEvent(
                        "Testname1","TestDesc1",
                        LocalDateTime.of(2018,05,01,12,30),
                        LocalDateTime.of((2018,05,01,18,30)),
                "Poznan","Poland",123.132,321.321));



    }
    //lista eventów


    //TODO dodać kilka common eventów
    ////TODO wydzielić to do osobnej klasy

    private CommonEvent mapEventBriteEventToCommonEvent(Events events) {
        //TODO mapowanie z events na obiekt typu common event i wypenić danymi z events

        //TODO jeśłi pole venue/address/country/city to null -- zwróć longi ze współ.
        return new CommonEvent();
    }
}