package com.eventapp.eventSources.eventBrite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class EventStartDate {
    private LocalDateTime startDateTime;
}
