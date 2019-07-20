package com.eventapp.eventSources.eventBrite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

class EventBriteEvent {

    @JsonProperty("name")
    private EventName name;
}
