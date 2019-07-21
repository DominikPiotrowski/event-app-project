package com.eventapp.eventSources.eventBrite.model;

import com.eventapp.models.CommonEvent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventBriteSearchResult {
    private List<EventBriteEvent> events;

    public List<CommonEvent> toCommonModel() {

        return events
                .stream()
                .map(EventBriteToCommonModelMapper::map)
                .collect(Collectors.toList());
    }
}