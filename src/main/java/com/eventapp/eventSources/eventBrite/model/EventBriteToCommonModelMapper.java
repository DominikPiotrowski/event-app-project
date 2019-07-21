package com.eventapp.eventSources.eventBrite.model;

import com.eventapp.models.CommonEvent;
import java.time.LocalDateTime;

class EventBriteToCommonModelMapper {
    static CommonEvent map(EventBriteEvent event) {

        CommonEvent commonEvent = CommonEvent.builder()
                .eventName(event.getName().getEventName())
                .eventDescription(event.getDescription().getDescription())
                .eventStartDate(LocalDateTime.parse(event.getStartDate().getEventStartDateTime()))
                .eventEndDate(LocalDateTime.parse(event.getEndDate().getEventEndDateTime()))
                .city(event.getVenue().getAddress().getCity())
                .country(event.getVenue().getAddress().getCountry())
                .eventLatitude(Long.valueOf(event.getVenue().getLatitude()))
                .eventLongitude(Long.valueOf(event.getVenue().getLongitude()))
                .build();

        return commonEvent;
    }
}