package com.eventapp.eventSources.eventBrite;

import com.eventapp.client.EventSource;
import com.eventapp.eventSources.eventBrite.model.Events;
import com.eventapp.models.CommonEvent;

public class EventBrite implements EventSource {
    @Override
    public CommonEvent getEventData() {
        Events events = new Events();
        return mapEventBriteEventToCommonEvent(events);
    }

    //TODO dodać kilka common eventów
    ////TODO wydzielić to do osobnej klasy

    private CommonEvent mapEventBriteEventToCommonEvent(Events events) {
        //TODO mapowanie z events na obiekt typu common event i wypenić danymi z events


        //TODO jeśłi pole venue/address/country/city to null -- zwróć longi ze współ.
        return new CommonEvent();
    }
}
