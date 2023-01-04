
package com.hypnotes.pojo.educationPojo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "zipCode",
    "country",
    "address",
    "state",
    "city",
    "timeZone",
    "addressTitle",
    "availability"
})
@Generated("jsonschema2pojo")
public class LocationInfo {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("country")
    private String country;
    @JsonProperty("address")
    private String address;
    @JsonProperty("state")
    private String state;
    @JsonProperty("city")
    private String city;
    @JsonProperty("timeZone")
    private String timeZone;
    @JsonProperty("addressTitle")
    private String addressTitle;
    @JsonProperty("availability")
    private Availability__1 availability;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("timeZone")
    public String getTimeZone() {
        return timeZone;
    }

    @JsonProperty("timeZone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("addressTitle")
    public String getAddressTitle() {
        return addressTitle;
    }

    @JsonProperty("addressTitle")
    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }

    @JsonProperty("availability")
    public Availability__1 getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(Availability__1 availability) {
        this.availability = availability;
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
