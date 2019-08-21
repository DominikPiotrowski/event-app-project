//package com.eventapp.client;
//
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class EventClient {
//
//    //bierze dane z API przy odpaleniu apki
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void EventClient() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization", "Bearer 46SOXBWJNV2ICD7WICT2");
//        HttpEntity httpEntity = new HttpEntity(httpHeaders);
//
//        ResponseEntity<EventBrait> exchange =
//                restTemplate.exchange("https://www.eventbriteapi.com/v3/events/search?location.longitude=52.4069200&location.latitude=16.9299300&location.within=900km&expand=venue",
//                        HttpMethod.GET,
//                        httpEntity,
//                        EventBrait.class);
//
//        EventBrait eventBrait = exchange.getBody();
//        System.out.println(eventBrait);
//    }
//}