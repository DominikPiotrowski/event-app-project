package com.eventapp.eventSources.eventBrite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

class EventBriteEvent {

    @JsonProperty("name")
    private EventName name;
    private EventDescription description;
    private EventStartDate startDate;
    private EventEndDate EndDate;
    private Country country;
    private City city;
    private EventLatitude latitude;
    private EventLongitude longitude;


}
