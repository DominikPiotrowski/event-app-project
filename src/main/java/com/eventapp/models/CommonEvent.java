package com.eventapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private String eventDescription;
    private LocalDateTime eventStartDate;
    private LocalDateTime eventEndDate;
    private String city;
    private String country;
    private Long eventLatitude;
    private Long eventLongitude;
}