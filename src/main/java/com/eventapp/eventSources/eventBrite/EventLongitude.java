package com.eventapp.eventSources.eventBrite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class EventLongitude {
    private Double eventLongitude;
}
