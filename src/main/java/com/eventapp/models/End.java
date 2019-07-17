
package com.eventapp.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "timezone",
        "local",
        "utc"
})
public class End {
    @Override
    public String toString() {
        return "End{" +
                "timezone='" + timezone + '\'' +
                ", local='" + local + '\'' +
                ", utc='" + utc + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("local")
    private String local;
    @JsonProperty("utc")
    private String utc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("local")
    public String getLocal() {
        return local;
    }

    @JsonProperty("local")
    public void setLocal(String local) {
        this.local = local;
    }

    @JsonProperty("utc")
    public String getUtc() {
        return utc;
    }

    @JsonProperty("utc")
    public void setUtc(String utc) {
        this.utc = utc;
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

