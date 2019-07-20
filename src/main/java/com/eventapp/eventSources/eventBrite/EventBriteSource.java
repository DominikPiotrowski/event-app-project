package com.eventapp.eventSources.eventBrite;

import com.eventapp.client.EventSource;
import com.eventapp.models.CommonEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventBriteSource implements EventSource {
    @Override
    public CommonEvent getEventData() {
        Events events = new Events();
        return mapEventBriteEventToCommonEvent(events);
    }

    //TESTOWO DWA EVENTY DO PRZEROBIENIA NA COMMON EVENT

    public List<EventBriteEvent> getEventList() {
        List<EventBriteEvent> result = new ArrayList<>();
        result.add(
                new EventBriteEvent(
                        new EventName("Testname1"), new EventDescription("TestDesc1"),
                        new EventStartDate(LocalDateTime.of(2018, 05, 01, 12, 30)),
                        new EventEndDate(LocalDateTime.of(2018, 05, 01, 18, 30)),
                        new Country("Poland"),
                        new City("Poznan"),
                        new EventLatitude(111.222),
                        new EventLongitude(333.444))
        );
        result.add(
                new EventBriteEvent(
                        new EventName("Testname2"), new EventDescription("TestDesc2"),
                        new EventStartDate(LocalDateTime.of(2020, 05, 01, 18, 30)),
                        new EventEndDate(LocalDateTime.of(2020, 05, 01, 22, 30)),
                        new Country("United Kingdom"),
                        new City("London"),
                        new EventLatitude(111.222),
                        new EventLongitude(333.444))
        );

        return result;
    }

    ////TODO wydzielić to do osobnej klasy

    private CommonEvent mapEventBriteEventToCommonEvent(Events events) {
        //TODO mapowanie z events na obiekt typu common event i wypenić danymi z events

        //TODO jeśłi pole venue/address/country/city to null -- zwróć longi ze współ.
        return new CommonEvent();
    }
}