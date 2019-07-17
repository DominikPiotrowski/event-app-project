
package com.evenapp.demo.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "x",
        "y"
})
public class TopLeft {

    @Override
    public String toString() {
        return "TopLeft{" +
                "x=" + x +
                ", y=" + y +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("x")
    private Integer x;
    @JsonProperty("y")
    private Integer y;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("x")
    public Integer getX() {
        return x;
    }

    @JsonProperty("x")
    public void setX(Integer x) {
        this.x = x;
    }

    @JsonProperty("y")
    public Integer getY() {
        return y;
    }

    @JsonProperty("y")
    public void setY(Integer y) {
        this.y = y;
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
