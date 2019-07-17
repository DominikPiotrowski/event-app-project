package com.eventapp.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "address_1",
        "address_2",
        "city",
        "region",
        "postal_code",
        "country",
        "latitude",
        "longitude",
        "localized_address_display",
        "localized_area_display",
        "localized_multi_line_address_display"
})
public class Address {

    @JsonProperty("address_1")
    private String address1;
    @JsonProperty("address_2")
    private Object address2;

    @Override
    public String toString() {
        return "Address{" +
                "address1='" + address1 + '\'' +
                ", address2=" + address2 +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postalCode=" + postalCode +
                ", country='" + country + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", localizedAddressDisplay='" + localizedAddressDisplay + '\'' +
                ", localizedAreaDisplay='" + localizedAreaDisplay + '\'' +
                ", localizedMultiLineAddressDisplay=" + localizedMultiLineAddressDisplay +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("city")
    private String city;
    @JsonProperty("region")
    private String region;
    @JsonProperty("postal_code")
    private Object postalCode;
    @JsonProperty("country")
    private String country;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("localized_address_display")
    private String localizedAddressDisplay;
    @JsonProperty("localized_area_display")
    private String localizedAreaDisplay;
    @JsonProperty("localized_multi_line_address_display")
    private List<String> localizedMultiLineAddressDisplay = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("address_1")
    public String getAddress1() {
        return address1;
    }

    @JsonProperty("address_1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @JsonProperty("address_2")
    public Object getAddress2() {
        return address2;
    }

    @JsonProperty("address_2")
    public void setAddress2(Object address2) {
        this.address2 = address2;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("postal_code")
    public Object getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postal_code")
    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("localized_address_display")
    public String getLocalizedAddressDisplay() {
        return localizedAddressDisplay;
    }

    @JsonProperty("localized_address_display")
    public void setLocalizedAddressDisplay(String localizedAddressDisplay) {
        this.localizedAddressDisplay = localizedAddressDisplay;
    }

    @JsonProperty("localized_area_display")
    public String getLocalizedAreaDisplay() {
        return localizedAreaDisplay;
    }

    @JsonProperty("localized_area_display")
    public void setLocalizedAreaDisplay(String localizedAreaDisplay) {
        this.localizedAreaDisplay = localizedAreaDisplay;
    }

    @JsonProperty("localized_multi_line_address_display")
    public List<String> getLocalizedMultiLineAddressDisplay() {
        return localizedMultiLineAddressDisplay;
    }

    @JsonProperty("localized_multi_line_address_display")
    public void setLocalizedMultiLineAddressDisplay(List<String> localizedMultiLineAddressDisplay) {
        this.localizedMultiLineAddressDisplay = localizedMultiLineAddressDisplay;
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