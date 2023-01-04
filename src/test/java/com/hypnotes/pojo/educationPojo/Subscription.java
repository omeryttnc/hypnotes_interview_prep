
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
    "uniqueName",
    "subscriptionId",
    "paymentType",
    "planId",
    "isActive",
    "billingIntervalUnit",
    "freeTrialDays",
    "price",
    "startedAt",
    "renewedAt",
    "setupFee",
    "info",
    "userId",
    "salePrice",
    "promoCode"
})
@Generated("jsonschema2pojo")
public class Subscription {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("uniqueName")
    private String uniqueName;
    @JsonProperty("subscriptionId")
    private String subscriptionId;
    @JsonProperty("paymentType")
    private String paymentType;
    @JsonProperty("planId")
    private String planId;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("billingIntervalUnit")
    private String billingIntervalUnit;
    @JsonProperty("freeTrialDays")
    private Integer freeTrialDays;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("startedAt")
    private StartedAt startedAt;
    @JsonProperty("renewedAt")
    private RenewedAt renewedAt;
    @JsonProperty("setupFee")
    private Integer setupFee;
    @JsonProperty("info")
    private Info info;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("salePrice")
    private Integer salePrice;
    @JsonProperty("promoCode")
    private Object promoCode;
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

    @JsonProperty("uniqueName")
    public String getUniqueName() {
        return uniqueName;
    }

    @JsonProperty("uniqueName")
    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    @JsonProperty("subscriptionId")
    public String getSubscriptionId() {
        return subscriptionId;
    }

    @JsonProperty("subscriptionId")
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @JsonProperty("paymentType")
    public String getPaymentType() {
        return paymentType;
    }

    @JsonProperty("paymentType")
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @JsonProperty("planId")
    public String getPlanId() {
        return planId;
    }

    @JsonProperty("planId")
    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("billingIntervalUnit")
    public String getBillingIntervalUnit() {
        return billingIntervalUnit;
    }

    @JsonProperty("billingIntervalUnit")
    public void setBillingIntervalUnit(String billingIntervalUnit) {
        this.billingIntervalUnit = billingIntervalUnit;
    }

    @JsonProperty("freeTrialDays")
    public Integer getFreeTrialDays() {
        return freeTrialDays;
    }

    @JsonProperty("freeTrialDays")
    public void setFreeTrialDays(Integer freeTrialDays) {
        this.freeTrialDays = freeTrialDays;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("startedAt")
    public StartedAt getStartedAt() {
        return startedAt;
    }

    @JsonProperty("startedAt")
    public void setStartedAt(StartedAt startedAt) {
        this.startedAt = startedAt;
    }

    @JsonProperty("renewedAt")
    public RenewedAt getRenewedAt() {
        return renewedAt;
    }

    @JsonProperty("renewedAt")
    public void setRenewedAt(RenewedAt renewedAt) {
        this.renewedAt = renewedAt;
    }

    @JsonProperty("setupFee")
    public Integer getSetupFee() {
        return setupFee;
    }

    @JsonProperty("setupFee")
    public void setSetupFee(Integer setupFee) {
        this.setupFee = setupFee;
    }

    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
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
    public Object getPromoCode() {
        return promoCode;
    }

    @JsonProperty("promoCode")
    public void setPromoCode(Object promoCode) {
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
