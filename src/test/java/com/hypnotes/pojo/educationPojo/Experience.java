
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
    "company",
    "jobTitle",
    "startedAt",
    "enddedAt",
    "description",
    "isActive"
})
@Generated("jsonschema2pojo")
public class Experience {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("company")
    private String company;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("startedAt")
    private StartedAt__2 startedAt;
    @JsonProperty("enddedAt")
    private EnddedAt__1 enddedAt;
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

    @JsonProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }

    @JsonProperty("jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("jobTitle")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @JsonProperty("startedAt")
    public StartedAt__2 getStartedAt() {
        return startedAt;
    }

    @JsonProperty("startedAt")
    public void setStartedAt(StartedAt__2 startedAt) {
        this.startedAt = startedAt;
    }

    @JsonProperty("enddedAt")
    public EnddedAt__1 getEnddedAt() {
        return enddedAt;
    }

    @JsonProperty("enddedAt")
    public void setEnddedAt(EnddedAt__1 enddedAt) {
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
