package com.eventapp.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "top_left",
        "width",
        "height"
})
public class CropMask {
    @Override
    public String toString() {
        return "CropMask{" +
                "topLeft=" + topLeft +
                ", width=" + width +
                ", height=" + height +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("top_left")
    private TopLeft topLeft;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("top_left")
    public TopLeft getTopLeft() {
        return topLeft;
    }

    @JsonProperty("top_left")
    public void setTopLeft(TopLeft topLeft) {
        this.topLeft = topLeft;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
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
