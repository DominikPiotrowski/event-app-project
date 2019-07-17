
package com.eventapp.models;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "latitude",
        "within",
        "longitude"
})
public class Location {
    @Override
    public String toString() {
        return "Location{" +
                "latitude='" + latitude + '\'' +
                ", within='" + within + '\'' +
                ", longitude='" + longitude + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("within")
    private String within;
    @JsonProperty("longitude")
    private String longitude;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("within")
    public String getWithin() {
        return within;
    }

    @JsonProperty("within")
    public void setWithin(String within) {
        this.within = within;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
