
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
    "schoolName",
    "department",
    "startedAt",
    "enddedAt",
    "description",
    "isActive"
})
@Generated("jsonschema2pojo")
public class Education {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("schoolName")
    private String schoolName;
    @JsonProperty("department")
    private String department;
    @JsonProperty("startedAt")
    private StartedAt__1 startedAt;
    @JsonProperty("enddedAt")
    private EnddedAt enddedAt;
    @JsonProperty("description")
    private String description;
    @JsonProperty("isActive")
    private Boolean isActive;
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

    @JsonProperty("schoolName")
    public String getSchoolName() {
        return schoolName;
    }

    @JsonProperty("schoolName")
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(String department) {
        this.department = department;
    }

    @JsonProperty("startedAt")
    public StartedAt__1 getStartedAt() {
        return startedAt;
    }

    @JsonProperty("startedAt")
    public void setStartedAt(StartedAt__1 startedAt) {
        this.startedAt = startedAt;
    }

    @JsonProperty("enddedAt")
    public EnddedAt getEnddedAt() {
        return enddedAt;
    }

    @JsonProperty("enddedAt")
    public void setEnddedAt(EnddedAt enddedAt) {
        this.enddedAt = enddedAt;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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
