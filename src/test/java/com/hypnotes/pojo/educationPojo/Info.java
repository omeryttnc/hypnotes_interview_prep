
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
    "billingIntervalUnit",
    "uniqueName",
    "subsType",
    "subscriptionId",
    "planId",
    "salePrice",
    "promoCode"
})
@Generated("jsonschema2pojo")
public class Info {

    @JsonProperty("billingIntervalUnit")
    private String billingIntervalUnit;
    @JsonProperty("uniqueName")
    private String uniqueName;
    @JsonProperty("subsType")
    private String subsType;
    @JsonProperty("subscriptionId")
    private String subscriptionId;
    @JsonProperty("planId")
    private String planId;
    @JsonProperty("salePrice")
    private Integer salePrice;
    @JsonProperty("promoCode")
    private String promoCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("billingIntervalUnit")
    public String getBillingIntervalUnit() {
        return billingIntervalUnit;
    }

    @JsonProperty("billingIntervalUnit")
    public void setBillingIntervalUnit(String billingIntervalUnit) {
        this.billingIntervalUnit = billingIntervalUnit;
    }

    @JsonProperty("uniqueName")
    public String getUniqueName() {
        return uniqueName;
    }

    @JsonProperty("uniqueName")
    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    @JsonProperty("subsType")
    public String getSubsType() {
        return subsType;
    }

    @JsonProperty("subsType")
    public void setSubsType(String subsType) {
        this.subsType = subsType;
    }

    @JsonProperty("subscriptionId")
    public String getSubscriptionId() {
        return subscriptionId;
    }

    @JsonProperty("subscriptionId")
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @JsonProperty("planId")
    public String getPlanId() {
        return planId;
    }

    @JsonProperty("planId")
    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @JsonProperty("salePrice")
    public Integer getSalePrice() {
        return salePrice;
    }

    @JsonProperty("salePrice")
    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    @JsonProperty("promoCode")
    public String getPromoCode() {
        return promoCode;
    }

    @JsonProperty("promoCode")
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
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
