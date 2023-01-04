
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
    "isPhoneVerified",
    "isEmailVerified",
    "isTwoFactorEnabled"
})
@Generated("jsonschema2pojo")
public class Security {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("isPhoneVerified")
    private Boolean isPhoneVerified;
    @JsonProperty("isEmailVerified")
    private Boolean isEmailVerified;
    @JsonProperty("isTwoFactorEnabled")
    private Boolean isTwoFactorEnabled;
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

    @JsonProperty("isPhoneVerified")
    public Boolean getIsPhoneVerified() {
        return isPhoneVerified;
    }

    @JsonProperty("isPhoneVerified")
    public void setIsPhoneVerified(Boolean isPhoneVerified) {
        this.isPhoneVerified = isPhoneVerified;
    }

    @JsonProperty("isEmailVerified")
    public Boolean getIsEmailVerified() {
        return isEmailVerified;
    }

    @JsonProperty("isEmailVerified")
    public void setIsEmailVerified(Boolean isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    @JsonProperty("isTwoFactorEnabled")
    public Boolean getIsTwoFactorEnabled() {
        return isTwoFactorEnabled;
    }

    @JsonProperty("isTwoFactorEnabled")
    public void setIsTwoFactorEnabled(Boolean isTwoFactorEnabled) {
        this.isTwoFactorEnabled = isTwoFactorEnabled;
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
