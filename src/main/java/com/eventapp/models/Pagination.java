package com.eventapp.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "object_count",
        "page_number",
        "page_size",
        "page_count",
        "has_more_items"
})
public class Pagination {

    @Override
    public String toString() {
        return "Pagination{" +
                "objectCount=" + objectCount +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", hasMoreItems=" + hasMoreItems +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("object_count")
    private Integer objectCount;
    @JsonProperty("page_number")
    private Integer pageNumber;
    @JsonProperty("page_size")
    private Integer pageSize;
    @JsonProperty("page_count")
    private Integer pageCount;
    @JsonProperty("has_more_items")
    private Boolean hasMoreItems;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("object_count")
    public Integer getObjectCount() {
        return objectCount;
    }

    @JsonProperty("object_count")
    public void setObjectCount(Integer objectCount) {
        this.objectCount = objectCount;
    }

    @JsonProperty("page_number")
    public Integer getPageNumber() {
        return pageNumber;
    }

    @JsonProperty("page_number")
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    @JsonProperty("page_size")
    public Integer getPageSize() {
        return pageSize;
    }

    @JsonProperty("page_size")
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @JsonProperty("page_count")
    public Integer getPageCount() {
        return pageCount;
    }

    @JsonProperty("page_count")
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @JsonProperty("has_more_items")
    public Boolean getHasMoreItems() {
        return hasMoreItems;
    }

    @JsonProperty("has_more_items")
    public void setHasMoreItems(Boolean hasMoreItems) {
        this.hasMoreItems = hasMoreItems;
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
