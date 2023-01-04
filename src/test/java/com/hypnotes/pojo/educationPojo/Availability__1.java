
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
    "monday",
    "tuesday",
    "wednesday",
    "thursday",
    "friday",
    "saturday",
    "sunday",
    "mondayClientLimit",
    "tuesdayClientLimit",
    "wednesdayClientLimit",
    "thursdayClientLimit",
    "fridayClientLimit",
    "saturdayClientLimit",
    "sundayClientLimit",
    "created",
    "updated"
})
@Generated("jsonschema2pojo")
public class Availability__1 {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("monday")
    private String monday;
    @JsonProperty("tuesday")
    private String tuesday;
    @JsonProperty("wednesday")
    private String wednesday;
    @JsonProperty("thursday")
    private String thursday;
    @JsonProperty("friday")
    private String friday;
    @JsonProperty("saturday")
    private String saturday;
    @JsonProperty("sunday")
    private String sunday;
    @JsonProperty("mondayClientLimit")
    private Integer mondayClientLimit;
    @JsonProperty("tuesdayClientLimit")
    private Integer tuesdayClientLimit;
    @JsonProperty("wednesdayClientLimit")
    private Integer wednesdayClientLimit;
    @JsonProperty("thursdayClientLimit")
    private Integer thursdayClientLimit;
    @JsonProperty("fridayClientLimit")
    private Integer fridayClientLimit;
    @JsonProperty("saturdayClientLimit")
    private Integer saturdayClientLimit;
    @JsonProperty("sundayClientLimit")
    private Integer sundayClientLimit;
    @JsonProperty("created")
    private Created__2 created;
    @JsonProperty("updated")
    private Updated__2 updated;
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

    @JsonProperty("monday")
    public String getMonday() {
        return monday;
    }

    @JsonProperty("monday")
    public void setMonday(String monday) {
        this.monday = monday;
    }

    @JsonProperty("tuesday")
    public String getTuesday() {
        return tuesday;
    }

    @JsonProperty("tuesday")
    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    @JsonProperty("wednesday")
    public String getWednesday() {
        return wednesday;
    }

    @JsonProperty("wednesday")
    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    @JsonProperty("thursday")
    public String getThursday() {
        return thursday;
    }

    @JsonProperty("thursday")
    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    @JsonProperty("friday")
    public String getFriday() {
        return friday;
    }

    @JsonProperty("friday")
    public void setFriday(String friday) {
        this.friday = friday;
    }

    @JsonProperty("saturday")
    public String getSaturday() {
        return saturday;
    }

    @JsonProperty("saturday")
    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    @JsonProperty("sunday")
    public String getSunday() {
        return sunday;
    }

    @JsonProperty("sunday")
    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    @JsonProperty("mondayClientLimit")
    public Integer getMondayClientLimit() {
        return mondayClientLimit;
    }

    @JsonProperty("mondayClientLimit")
    public void setMondayClientLimit(Integer mondayClientLimit) {
        this.mondayClientLimit = mondayClientLimit;
    }

    @JsonProperty("tuesdayClientLimit")
    public Integer getTuesdayClientLimit() {
        return tuesdayClientLimit;
    }

    @JsonProperty("tuesdayClientLimit")
    public void setTuesdayClientLimit(Integer tuesdayClientLimit) {
        this.tuesdayClientLimit = tuesdayClientLimit;
    }

    @JsonProperty("wednesdayClientLimit")
    public Integer getWednesdayClientLimit() {
        return wednesdayClientLimit;
    }

    @JsonProperty("wednesdayClientLimit")
    public void setWednesdayClientLimit(Integer wednesdayClientLimit) {
        this.wednesdayClientLimit = wednesdayClientLimit;
    }

    @JsonProperty("thursdayClientLimit")
    public Integer getThursdayClientLimit() {
        return thursdayClientLimit;
    }

    @JsonProperty("thursdayClientLimit")
    public void setThursdayClientLimit(Integer thursdayClientLimit) {
        this.thursdayClientLimit = thursdayClientLimit;
    }

    @JsonProperty("fridayClientLimit")
    public Integer getFridayClientLimit() {
        return fridayClientLimit;
    }

    @JsonProperty("fridayClientLimit")
    public void setFridayClientLimit(Integer fridayClientLimit) {
        this.fridayClientLimit = fridayClientLimit;
    }

    @JsonProperty("saturdayClientLimit")
    public Integer getSaturdayClientLimit() {
        return saturdayClientLimit;
    }

    @JsonProperty("saturdayClientLimit")
    public void setSaturdayClientLimit(Integer saturdayClientLimit) {
        this.saturdayClientLimit = saturdayClientLimit;
    }

    @JsonProperty("sundayClientLimit")
    public Integer getSundayClientLimit() {
        return sundayClientLimit;
    }

    @JsonProperty("sundayClientLimit")
    public void setSundayClientLimit(Integer sundayClientLimit) {
        this.sundayClientLimit = sundayClientLimit;
    }

    @JsonProperty("created")
    public Created__2 getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Created__2 created) {
        this.created = created;
    }

    @JsonProperty("updated")
    public Updated__2 getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Updated__2 updated) {
        this.updated = updated;
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
