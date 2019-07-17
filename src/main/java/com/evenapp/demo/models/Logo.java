
package com.evenapp.demo.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "crop_mask",
        "original",
        "id",
        "url",
        "aspect_ratio",
        "edge_color",
        "edge_color_set"
})
public class Logo {

    @Override
    public String toString() {
        return "Logo{" +
                "cropMask=" + cropMask +
                ", original=" + original +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", aspectRatio='" + aspectRatio + '\'' +
                ", edgeColor=" + edgeColor +
                ", edgeColorSet=" + edgeColorSet +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("crop_mask")
    private CropMask cropMask;
    @JsonProperty("original")
    private Original original;
    @JsonProperty("id")
    private String id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("aspect_ratio")
    private String aspectRatio;
    @JsonProperty("edge_color")
    private Object edgeColor;
    @JsonProperty("edge_color_set")
    private Boolean edgeColorSet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("crop_mask")
    public CropMask getCropMask() {
        return cropMask;
    }

    @JsonProperty("crop_mask")
    public void setCropMask(CropMask cropMask) {
        this.cropMask = cropMask;
    }

    @JsonProperty("original")
    public Original getOriginal() {
        return original;
    }

    @JsonProperty("original")
    public void setOriginal(Original original) {
        this.original = original;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("aspect_ratio")
    public String getAspectRatio() {
        return aspectRatio;
    }

    @JsonProperty("aspect_ratio")
    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    @JsonProperty("edge_color")
    public Object getEdgeColor() {
        return edgeColor;
    }

    @JsonProperty("edge_color")
    public void setEdgeColor(Object edgeColor) {
        this.edgeColor = edgeColor;
    }

    @JsonProperty("edge_color_set")
    public Boolean getEdgeColorSet() {
        return edgeColorSet;
    }

    @JsonProperty("edge_color_set")
    public void setEdgeColorSet(Boolean edgeColorSet) {
        this.edgeColorSet = edgeColorSet;
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
