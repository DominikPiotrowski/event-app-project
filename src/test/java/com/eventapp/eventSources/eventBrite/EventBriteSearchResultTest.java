package com.eventapp.eventSources.eventBrite;

import com.eventapp.eventSources.eventBrite.eventBriteModel.EventBriteSearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class EventBriteSearchResultTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldSerializeWithNoErrors() throws IOException {

        byte[] file = Files.readAllBytes(Paths.get("C:/Users/piotr/IdeaProjects/eventAppProject/target/test-classes/test.json"));
        String testJson = new String(file,"UTF-8");

        EventBriteSearchResult eventBriteSearchResult = objectMapper.readValue(testJson, EventBriteSearchResult.class);
        assertNotNull(eventBriteSearchResult);
    }
}