package com.eventapp.eventSources.eventBrite;

import com.eventapp.client.EventSource;
import com.eventapp.eventSources.eventBrite.eventBriteModel.EventBriteSearchResult;
import com.eventapp.models.CommonEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Component
public class EventBriteSource implements EventSource {

    private RestTemplate restTemplate;

    @Override
    public List<CommonEvent> getEventData() throws IOException {
        EventBriteSearchResult events = getSearchResult();
        return events.toCommonModel();
    }

    private EventBriteSearchResult getSearchResult() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        EventBriteSearchResult eventBriteSearchResult = objectMapper.readValue(getJsonString(), EventBriteSearchResult.class);
        return eventBriteSearchResult;
    }

    private String getJsonString() {
        ResponseEntity<String> exchange =
                restTemplate.exchange("https://www.eventbrite.com/oauth/authorize",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class);
        String json = exchange.getBody();
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        String jsonAsString = jsonObject.getAsString();
        return jsonAsString;
//
//        "{\n" +
//                "  \"pagination\": {\n" +
//                "    \"object_count\": 0,\n" +
//                "    \"page_numbner\": 0,\n" +
//                "    \"page_size\": 0,\n" +
//                "    \"page_count\": 0,\n" +
//                "    \"continuation\": \"dGhpcyBpcyBhIGNvbnRpbnVhdGlvbiB0b2tlbg\",\n" +
//                "    \"has_more_items\": false\n" +
//                "  },\n" +
//                "  \"events\": [\n" +
//                "    {\n" +
//                "      \"id\": \"12345\",\n" +
//                "      \"name\": {\n" +
//                "        \"text\": \"Some text\",\n" +
//                "        \"html\": \"<p>Some text</p>\"\n" +
//                "      },\n" +
//                "      \"description\": {\n" +
//                "        \"text\": \"Some text\",\n" +
//                "        \"html\": \"<p>Some text</p>\"\n" +
//                "      },\n" +
//                "      \"start\": {\n" +
//                "        \"timezone\": \"America/Los_Angeles\",\n" +
//                "        \"utc\": \"2018-05-12T02:00:00Z\",\n" +
//                "        \"local\": \"2018-05-11T19:00:00\"\n" +
//                "      },\n" +
//                "      \"end\": {\n" +
//                "        \"timezone\": \"America/Los_Angeles\",\n" +
//                "        \"utc\": \"2018-05-12T02:00:00Z\",\n" +
//                "        \"local\": \"2018-05-11T19:00:00\"\n" +
//                "      },\n" +
//                "      \"url\": \"https://www.eventbrite.com/e/45263283700\",\n" +
//                "      \"vanity_url\": \"https://testevent.eventbrite.com\",\n" +
//                "      \"created\": \"2017-02-19T20:28:14Z\",\n" +
//                "      \"changed\": \"2017-02-19T20:28:14Z\",\n" +
//                "      \"published\": \"2017-02-19T20:28:14Z\",\n" +
//                "      \"status\": \"live\",\n" +
//                "      \"currency\": \"USD\",\n" +
//                "      \"online_event\": false,\n" +
//                "      \"organization_id\": \"\",\n" +
//                "      \"organizer_id\": \"\",\n" +
//                "      \"organizer\": {\n" +
//                "        \"name\": \"\",\n" +
//                "        \"description\": {\n" +
//                "          \"text\": \"Some text\",\n" +
//                "          \"html\": \"<p>Some text</p>\"\n" +
//                "        },\n" +
//                "        \"long_description\": {\n" +
//                "          \"text\": \"Some text\",\n" +
//                "          \"html\": \"<p>Some text</p>\"\n" +
//                "        },\n" +
//                "        \"logo_id\": null,\n" +
//                "        \"logo\": {\n" +
//                "          \"id\": \"12345\",\n" +
//                "          \"url\": \"https://image.com\",\n" +
//                "          \"crop_mask\": {\n" +
//                "            \"top_left\": {\n" +
//                "              \"y\": 15,\n" +
//                "              \"x\": 15\n" +
//                "            },\n" +
//                "            \"width\": 15,\n" +
//                "            \"height\": 15\n" +
//                "          },\n" +
//                "          \"original\": {\n" +
//                "            \"url\": \"https://image.com\",\n" +
//                "            \"width\": 800,\n" +
//                "            \"height\": 400\n" +
//                "          },\n" +
//                "          \"aspect_ratio\": \"2\",\n" +
//                "          \"edge_color\": \"#6a7c8b\",\n" +
//                "          \"edge_color_set\": true\n" +
//                "        },\n" +
//                "        \"resource_uri\": \"https://www.eventbriteapi.com/v3/organizers/12345/\",\n" +
//                "        \"id\": \"12345\",\n" +
//                "        \"url\": \"https://www.eventbrite.com/o/12345/\",\n" +
//                "        \"num_past_events\": 5,\n" +
//                "        \"num_future_events\": 1,\n" +
//                "        \"twitter\": \"@abc\",\n" +
//                "        \"facebook\": \"abc\"\n" +
//                "      },\n" +
//                "      \"logo_id\": null,\n" +
//                "      \"logo\": {\n" +
//                "        \"id\": \"12345\",\n" +
//                "        \"url\": \"https://image.com\",\n" +
//                "        \"crop_mask\": {\n" +
//                "          \"top_left\": {\n" +
//                "            \"y\": 15,\n" +
//                "            \"x\": 15\n" +
//                "          },\n" +
//                "          \"width\": 15,\n" +
//                "          \"height\": 15\n" +
//                "        },\n" +
//                "        \"original\": {\n" +
//                "          \"url\": \"https://image.com\",\n" +
//                "          \"width\": 800,\n" +
//                "          \"height\": 400\n" +
//                "        },\n" +
//                "        \"aspect_ratio\": \"2\",\n" +
//                "        \"edge_color\": \"#6a7c8b\",\n" +
//                "        \"edge_color_set\": true\n" +
//                "      },\n" +
//                "      \"venue\": {\n" +
//                "        \"name\": \"Great Venue\",\n" +
//                "        \"age_restriction\": null,\n" +
//                "        \"capacity\": 100,\n" +
//                "        \"address\": {\n" +
//                "          \t\"address_1\": \"\",\n" +
//                "          \t\"address_2\": \"\",\n" +
//                "         \t \"city\": \"testCity\",\n" +
//                "          \t\"region\": \"\",\n" +
//                "          \t\"postal_code\": \"\",\n" +
//                "          \t\"country\": \"testCountry\",\n" +
//                "          \t\"latitude\": \"\",\n" +
//                "          \t\"longitude\": \"\",\n" +
//                "         \t \"localized_address_display\": \"\",\n" +
//                "          \t\"localized_area_display\": \"\",\n" +
//                "          \"localized_multi_line_address_display\": []\n" +
//                "        },\n" +
//                "        \"resource_uri\": \"https://www.eventbriteapi.com/v3/venues/3003/\",\n" +
//                "        \"id\": \"3003\",\n" +
//                "        \"latitude\": \"49.28497549999999\",\n" +
//                "        \"longitude\": \"123.11082529999999\"\n" +
//                "      },\n" +
//                "      \"format_id\": null,\n" +
//                "      \"format\": {\n" +
//                "        \"id\": \"2\",\n" +
//                "        \"name\": \"Seminar or Talk\",\n" +
//                "        \"name_localized\": \"Seminar or Talk\",\n" +
//                "        \"short_name\": \"Seminar\",\n" +
//                "        \"short_name_localized\": \"Seminar\",\n" +
//                "        \"resource_uri\": \"https://www.eventbriteapi.com/v3/formats/2/\"\n" +
//                "      },\n" +
//                "      \"category\": {\n" +
//                "        \"id\": \"103\",\n" +
//                "        \"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/103/\",\n" +
//                "        \"name\": \"Music\",\n" +
//                "        \"name_localized\": \"Music\",\n" +
//                "        \"short_name\": \"Music\",\n" +
//                "        \"short_name_localized\": \"Music\",\n" +
//                "        \"subcategories\": [\n" +
//                "          {\n" +
//                "            \"id\": \"3003\",\n" +
//                "            \"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/3003/\",\n" +
//                "            \"name\": \"Classical\",\n" +
//                "            \"parent_category\": {}\n" +
//                "          }\n" +
//                "        ]\n" +
//                "      },\n" +
//                "      \"subcategory\": {\n" +
//                "        \"id\": \"3003\",\n" +
//                "        \"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/3003/\",\n" +
//                "        \"name\": \"Classical\",\n" +
//                "        \"parent_category\": {\n" +
//                "          \"id\": \"103\",\n" +
//                "          \"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/103/\",\n" +
//                "          \"name\": \"Music\",\n" +
//                "          \"name_localized\": \"Music\",\n" +
//                "          \"short_name\": \"Music\",\n" +
//                "          \"short_name_localized\": \"Music\",\n" +
//                "          \"subcategories\": [\n" +
//                "            {}\n" +
//                "          ]\n" +
//                "        }\n" +
//                "      },\n" +
//                "      \"music_properties\": {\n" +
//                "        \"age_restriction\": null,\n" +
//                "        \"presented_by\": null,\n" +
//                "        \"door_time\": \"2019-05-12T-19:00:00Z\"\n" +
//                "      },\n" +
//                "      \"bookmark_info\": {\n" +
//                "        \"bookmarked\": false\n" +
//                "      },\n" +
//                "      \"ticket_availability\": {\n" +
//                "        \"has_available_tickets\": false,\n" +
//                "        \"minimum_ticket_price\": {\n" +
//                "          \"currency\": \"USD\",\n" +
//                "          \"value\": 432,\n" +
//                "          \"major_value\": \"4.32\",\n" +
//                "          \"display\": \"4.32 USD\"\n" +
//                "        },\n" +
//                "        \"maximum_ticket_price\": {\n" +
//                "          \"currency\": \"USD\",\n" +
//                "          \"value\": 432,\n" +
//                "          \"major_value\": \"4.32\",\n" +
//                "          \"display\": \"4.32 USD\"\n" +
//                "        },\n" +
//                "        \"is_sold_out\": true,\n" +
//                "        \"start_sales_date\": {\n" +
//                "          \"timezone\": \"America/Los_Angeles\",\n" +
//                "          \"utc\": \"2018-05-12T02:00:00Z\",\n" +
//                "          \"local\": \"2018-05-11T19:00:00\"\n" +
//                "        },\n" +
//                "        \"waitlist_available\": false\n" +
//                "      },\n" +
//                "      \"listed\": false,\n" +
//                "      \"shareable\": false,\n" +
//                "      \"invite_only\": false,\n" +
//                "      \"show_remaining\": true,\n" +
//                "      \"password\": \"12345\",\n" +
//                "      \"capacity\": 100,\n" +
//                "      \"capacity_is_custom\": true,\n" +
//                "      \"tx_time_limit\": \"12345\",\n" +
//                "      \"hide_start_date\": true,\n" +
//                "      \"hide_end_date\": true,\n" +
//                "      \"locale\": \"en_US\",\n" +
//                "      \"is_locked\": true,\n" +
//                "      \"privacy_setting\": \"unlocked\",\n" +
//                "      \"is_externally_ticketed\": false,\n" +
//                "      \"is_series\": true,\n" +
//                "      \"is_series_parent\": true,\n" +
//                "      \"is_reserved_seating\": true,\n" +
//                "      \"show_pick_a_seat\": true,\n" +
//                "      \"show_seatmap_thumbnail\": true,\n" +
//                "      \"show_colors_in_seatmap_thumbnail\": true,\n" +
//                "      \"is_free\": true,\n" +
//                "      \"source\": \"api\",\n" +
//                "      \"version\": \"null\",\n" +
//                "      \"resource_uri\": \"https://www.eventbriteapi.com/v3/events/1234/\",\n" +
//                "      \"event_sales_status\": {\n" +
//                "        \"sales_status\": \"text\",\n" +
//                "        \"start_sales_date\": {\n" +
//                "          \"timezone\": \"America/Los_Angeles\",\n" +
//                "          \"utc\": \"2018-05-12T02:00:00Z\",\n" +
//                "          \"local\": \"2018-05-11T19:00:00\"\n" +
//                "        }\n" +
//                "      },\n" +
//                "      \"checkout_settings\": {\n" +
//                "        \"created\": \"2018-01-31T13:00:00Z\",\n" +
//                "        \"changed\": \"2018-01-31T13:00:00Z\",\n" +
//                "        \"country_code\": \"\",\n" +
//                "        \"currency_code\": \"\",\n" +
//                "        \"checkout_method\": \"paypal\",\n" +
//                "        \"offline_settings\": [\n" +
//                "          {\n" +
//                "            \"payment_method\": \"CASH\",\n" +
//                "            \"instructions\": \"\"\n" +
//                "          }\n" +
//                "        ],\n" +
//                "        \"user_instrument_vault_id\": \"\"\n" +
//                "      }\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";
    }


}