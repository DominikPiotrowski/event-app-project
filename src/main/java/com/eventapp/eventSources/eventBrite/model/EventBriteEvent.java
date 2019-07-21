package com.eventapp.eventSources.eventBrite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

class EventBriteEvent {

    @JsonProperty("name")
    private EventName name;
    @JsonProperty("description")
    private EventDescription description;
    @JsonProperty("start")
    private EventStartDate startDate;
    @JsonProperty("end")
    private EventEndDate endDate;
    @JsonProperty("venue")
    private EventVenue venue;
}