package com.eventapp.eventSources.eventBrite;

import com.eventapp.client.EventSource;
import com.eventapp.eventSources.eventBrite.eventBriteModel.EventBriteSearchResult;
import com.eventapp.models.CommonEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Component
public class EventBriteSource implements EventSource {

    private RestTemplate restTemplate;

    @Override
    public List<CommonEvent> getEventData(Map parameters) throws IOException {
        EventBriteSearchResult events = getSearchResult(parameters);
        return events.toCommonModel();
    }

    private EventBriteSearchResult getSearchResult(Map parameters) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        EventBriteSearchResult eventBriteSearchResult =
                objectMapper.readValue(getJsonString(parameters), EventBriteSearchResult.class);
        return eventBriteSearchResult;
    }

    private String getJsonString(Map parameters) {
        ResponseEntity<EventBriteSearchResult> exchange =
                restTemplate.getForEntity("https://www.eventbrite.com/oauth/authorize",
                        EventBriteSearchResult.class,
                        convertParametersToEventBriteFormat(parameters));
        EventBriteSearchResult json = exchange.getBody();
        JsonObject jsonObject = new JsonParser().parse(String.valueOf(json)).getAsJsonObject();
        String jsonAsString = jsonObject.getAsString();
        return jsonAsString;
    }

    private Map<String, String> convertParametersToEventBriteFormat(Map parameters) {

        Map<String, String> briteMap = new HashMap<>();

        for (Object entry : parameters.values()) {

            parameters.put(String.valueOf(SearchParams.EVENT_NAME), eventName);
            briteMap.put(entry);
        }
        //pobrać w pętli wartości z parameters i wpisywać pod kluczami do nowej mapy
        //to z API brita

        return briteMap;
    }

}