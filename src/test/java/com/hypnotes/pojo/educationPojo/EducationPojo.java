
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
    "email",
    "roles",
    "fullname",
    "created",
    "updated",
    "phone",
    "schedulerId",
    "hipaaAcknowledge",
    "about",
    "paypalId",
    "stripeId",
    "facebookId",
    "googleId",
    "linkedinId",
    "flexibleMeetingTime",
    "timeZone",
    "quickStart",
    "multiInput",
    "showCancelMeetings",
    "multiUser",
    "referCode",
    "referUserId",
    "showTherapist",
    "googleToHypnotes",
    "hypnotesToGoogle",
    "security",
    "subscription",
    "availability",
    "userInvoiceInfo",
    "profile",
    "locationInfos",
    "schedulerPageSetting",
    "needCalendarAuth",
    "zoomConnected",
    "referedUserCount"
})
@Generated("jsonschema2pojo")
public class EducationPojo {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("roles")
    private List<String> roles = null;
    @JsonProperty("fullname")
    private String fullname;
    @JsonProperty("created")
    private Created created;
    @JsonProperty("updated")
    private Updated updated;
    @JsonProperty("phone")
    private Object phone;
    @JsonProperty("schedulerId")
    private String schedulerId;
    @JsonProperty("hipaaAcknowledge")
    private HipaaAcknowledge hipaaAcknowledge;
    @JsonProperty("about")
    private String about;
    @JsonProperty("paypalId")
    private Object paypalId;
    @JsonProperty("stripeId")
    private Object stripeId;
    @JsonProperty("facebookId")
    private Object facebookId;
    @JsonProperty("googleId")
    private Object googleId;
    @JsonProperty("linkedinId")
    private Object linkedinId;
    @JsonProperty("flexibleMeetingTime")
    private Boolean flexibleMeetingTime;
    @JsonProperty("timeZone")
    private String timeZone;
    @JsonProperty("quickStart")
    private Boolean quickStart;
    @JsonProperty("multiInput")
    private List<Object> multiInput = null;
    @JsonProperty("showCancelMeetings")
    private Boolean showCancelMeetings;
    @JsonProperty("multiUser")
    private List<Object> multiUser = null;
    @JsonProperty("referCode")
    private String referCode;
    @JsonProperty("referUserId")
    private Object referUserId;
    @JsonProperty("showTherapist")
    private Boolean showTherapist;
    @JsonProperty("googleToHypnotes")
    private Boolean googleToHypnotes;
    @JsonProperty("hypnotesToGoogle")
    private Boolean hypnotesToGoogle;
    @JsonProperty("security")
    private Security security;
    @JsonProperty("subscription")
    private Subscription subscription;
    @JsonProperty("availability")
    private Availability availability;
    @JsonProperty("userInvoiceInfo")
    private UserInvoiceInfo userInvoiceInfo;
    @JsonProperty("profile")
    private Profile profile;
    @JsonProperty("locationInfos")
    private List<LocationInfo> locationInfos = null;
    @JsonProperty("schedulerPageSetting")
    private Object schedulerPageSetting;
    @JsonProperty("needCalendarAuth")
    private Boolean needCalendarAuth;
    @JsonProperty("zoomConnected")
    private Boolean zoomConnected;
    @JsonProperty("referedUserCount")
    private Integer referedUserCount;
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

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("roles")
    public List<String> getRoles() {
        return roles;
    }

    @JsonProperty("roles")
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @JsonProperty("fullname")
    public String getFullname() {
        return fullname;
    }

    @JsonProperty("fullname")
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @JsonProperty("created")
    public Created getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Created created) {
        this.created = created;
    }

    @JsonProperty("updated")
    public Updated getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Updated updated) {
        this.updated = updated;
    }

    @JsonProperty("phone")
    public Object getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(Object phone) {
        this.phone = phone;
    }

    @JsonProperty("schedulerId")
    public String getSchedulerId() {
        return schedulerId;
    }

    @JsonProperty("schedulerId")
    public void setSchedulerId(String schedulerId) {
        this.schedulerId = schedulerId;
    }

    @JsonProperty("hipaaAcknowledge")
    public HipaaAcknowledge getHipaaAcknowledge() {
        return hipaaAcknowledge;
    }

    @JsonProperty("hipaaAcknowledge")
    public void setHipaaAcknowledge(HipaaAcknowledge hipaaAcknowledge) {
        this.hipaaAcknowledge = hipaaAcknowledge;
    }

    @JsonProperty("about")
    public String getAbout() {
        return about;
    }

    @JsonProperty("about")
    public void setAbout(String about) {
        this.about = about;
    }

    @JsonProperty("paypalId")
    public Object getPaypalId() {
        return paypalId;
    }

    @JsonProperty("paypalId")
    public void setPaypalId(Object paypalId) {
        this.paypalId = paypalId;
    }

    @JsonProperty("stripeId")
    public Object getStripeId() {
        return stripeId;
    }

    @JsonProperty("stripeId")
    public void setStripeId(Object stripeId) {
        this.stripeId = stripeId;
    }

    @JsonProperty("facebookId")
    public Object getFacebookId() {
        return facebookId;
    }

    @JsonProperty("facebookId")
    public void setFacebookId(Object facebookId) {
        this.facebookId = facebookId;
    }

    @JsonProperty("googleId")
    public Object getGoogleId() {
        return googleId;
    }

    @JsonProperty("googleId")
    public void setGoogleId(Object googleId) {
        this.googleId = googleId;
    }

    @JsonProperty("linkedinId")
    public Object getLinkedinId() {
        return linkedinId;
    }

    @JsonProperty("linkedinId")
    public void setLinkedinId(Object linkedinId) {
        this.linkedinId = linkedinId;
    }

    @JsonProperty("flexibleMeetingTime")
    public Boolean getFlexibleMeetingTime() {
        return flexibleMeetingTime;
    }

    @JsonProperty("flexibleMeetingTime")
    public void setFlexibleMeetingTime(Boolean flexibleMeetingTime) {
        this.flexibleMeetingTime = flexibleMeetingTime;
    }

    @JsonProperty("timeZone")
    public String getTimeZone() {
        return timeZone;
    }

    @JsonProperty("timeZone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("quickStart")
    public Boolean getQuickStart() {
        return quickStart;
    }

    @JsonProperty("quickStart")
    public void setQuickStart(Boolean quickStart) {
        this.quickStart = quickStart;
    }

    @JsonProperty("multiInput")
    public List<Object> getMultiInput() {
        return multiInput;
    }

    @JsonProperty("multiInput")
    public void setMultiInput(List<Object> multiInput) {
        this.multiInput = multiInput;
    }

    @JsonProperty("showCancelMeetings")
    public Boolean getShowCancelMeetings() {
        return showCancelMeetings;
    }

    @JsonProperty("showCancelMeetings")
    public void setShowCancelMeetings(Boolean showCancelMeetings) {
        this.showCancelMeetings = showCancelMeetings;
    }

    @JsonProperty("multiUser")
    public List<Object> getMultiUser() {
        return multiUser;
    }

    @JsonProperty("multiUser")
    public void setMultiUser(List<Object> multiUser) {
        this.multiUser = multiUser;
    }

    @JsonProperty("referCode")
    public String getReferCode() {
        return referCode;
    }

    @JsonProperty("referCode")
    public void setReferCode(String referCode) {
        this.referCode = referCode;
    }

    @JsonProperty("referUserId")
    public Object getReferUserId() {
        return referUserId;
    }

    @JsonProperty("referUserId")
    public void setReferUserId(Object referUserId) {
        this.referUserId = referUserId;
    }

    @JsonProperty("showTherapist")
    public Boolean getShowTherapist() {
        return showTherapist;
    }

    @JsonProperty("showTherapist")
    public void setShowTherapist(Boolean showTherapist) {
        this.showTherapist = showTherapist;
    }

    @JsonProperty("googleToHypnotes")
    public Boolean getGoogleToHypnotes() {
        return googleToHypnotes;
    }

    @JsonProperty("googleToHypnotes")
    public void setGoogleToHypnotes(Boolean googleToHypnotes) {
        this.googleToHypnotes = googleToHypnotes;
    }

    @JsonProperty("hypnotesToGoogle")
    public Boolean getHypnotesToGoogle() {
        return hypnotesToGoogle;
    }

    @JsonProperty("hypnotesToGoogle")
    public void setHypnotesToGoogle(Boolean hypnotesToGoogle) {
        this.hypnotesToGoogle = hypnotesToGoogle;
    }

    @JsonProperty("security")
    public Security getSecurity() {
        return security;
    }

    @JsonProperty("security")
    public void setSecurity(Security security) {
        this.security = security;
    }

    @JsonProperty("subscription")
    public Subscription getSubscription() {
        return subscription;
    }

    @JsonProperty("subscription")
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @JsonProperty("availability")
    public Availability getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    @JsonProperty("userInvoiceInfo")
    public UserInvoiceInfo getUserInvoiceInfo() {
        return userInvoiceInfo;
    }

    @JsonProperty("userInvoiceInfo")
    public void setUserInvoiceInfo(UserInvoiceInfo userInvoiceInfo) {
        this.userInvoiceInfo = userInvoiceInfo;
    }

    @JsonProperty("profile")
    public Profile getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @JsonProperty("locationInfos")
    public List<LocationInfo> getLocationInfos() {
        return locationInfos;
    }

    @JsonProperty("locationInfos")
    public void setLocationInfos(List<LocationInfo> locationInfos) {
        this.locationInfos = locationInfos;
    }

    @JsonProperty("schedulerPageSetting")
    public Object getSchedulerPageSetting() {
        return schedulerPageSetting;
    }

    @JsonProperty("schedulerPageSetting")
    public void setSchedulerPageSetting(Object schedulerPageSetting) {
        this.schedulerPageSetting = schedulerPageSetting;
    }

    @JsonProperty("needCalendarAuth")
    public Boolean getNeedCalendarAuth() {
        return needCalendarAuth;
    }

    @JsonProperty("needCalendarAuth")
    public void setNeedCalendarAuth(Boolean needCalendarAuth) {
        this.needCalendarAuth = needCalendarAuth;
    }

    @JsonProperty("zoomConnected")
    public Boolean getZoomConnected() {
        return zoomConnected;
    }

    @JsonProperty("zoomConnected")
    public void setZoomConnected(Boolean zoomConnected) {
        this.zoomConnected = zoomConnected;
    }

    @JsonProperty("referedUserCount")
    public Integer getReferedUserCount() {
        return referedUserCount;
    }

    @JsonProperty("referedUserCount")
    public void setReferedUserCount(Integer referedUserCount) {
        this.referedUserCount = referedUserCount;
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
