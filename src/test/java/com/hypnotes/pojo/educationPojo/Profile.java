
package com.hypnotes.pojo.educationPojo;

import java.util.HashMap;
import java.util.List;
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
    "image",
    "country",
    "address",
    "state",
    "city",
    "zipCode",
    "specialities",
    "jobTitle",
    "educations",
    "experiences",
    "certificates"
})
@Generated("jsonschema2pojo")
public class Profile {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("image")
    private String image;
    @JsonProperty("country")
    private String country;
    @JsonProperty("address")
    private String address;
    @JsonProperty("state")
    private String state;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("specialities")
    private List<String> specialities = null;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("educations")
    private List<Education> educations = null;
    @JsonProperty("experiences")
    private List<Experience> experiences = null;
    @JsonProperty("certificates")
    private List<Object> certificates = null;
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

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
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

    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @JsonProperty("specialities")
    public List<String> getSpecialities() {
        return specialities;
    }

    @JsonProperty("specialities")
    public void setSpecialities(List<String> specialities) {
        this.specialities = specialities;
    }

    @JsonProperty("jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("jobTitle")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @JsonProperty("educations")
    public List<Education> getEducations() {
        return educations;
    }

    @JsonProperty("educations")
    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    @JsonProperty("experiences")
    public List<Experience> getExperiences() {
        return experiences;
    }

    @JsonProperty("experiences")
    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    @JsonProperty("certificates")
    public List<Object> getCertificates() {
        return certificates;
    }

    @JsonProperty("certificates")
    public void setCertificates(List<Object> certificates) {
        this.certificates = certificates;
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
