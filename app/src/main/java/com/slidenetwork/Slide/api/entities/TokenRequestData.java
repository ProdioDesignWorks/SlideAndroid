package com.slidenetwork.Slide.api.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "auth_method",
        "auth_token",
        "email",
        "device_name",
        "device_display",
        "device_identifier",
        "local_time",
        "locale"
})
public class TokenRequestData {

    @JsonProperty("type")
    private String type;
    @JsonProperty("auth_method")
    private String auth_method;
    @JsonProperty("auth_token")
    private String auth_token;
    @JsonProperty("email")
    private String email;
    @JsonProperty("device_name")
    private String device_name;
    @JsonProperty("device_display")
    private List<Integer> device_display = new ArrayList<Integer>();
    @JsonProperty("device_identifier")
    private String device_identifier;
    @JsonProperty("local_time")
    private String local_time;
    @JsonProperty("locale")
    private String locale;

    /**
     *
     * @return
     * The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The authMethod
     */
    @JsonProperty("auth_method")
    public String getAuthMethod() {
        return auth_method;
    }

    /**
     *
     * @param authMethod
     * The auth_method
     */
    @JsonProperty("auth_method")
    public void setAuthMethod(String authMethod) {
        this.auth_method = authMethod;
    }

    /**
     *
     * @return
     * The authToken
     */
    @JsonProperty("auth_token")
    public String getAuthToken() {
        return auth_token;
    }

    /**
     *
     * @param authToken
     * The auth_token
     */
    @JsonProperty("auth_token")
    public void setAuthToken(String authToken) {
        this.auth_token = authToken;
    }

    /**
     *
     * @return
     * The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The deviceName
     */
    @JsonProperty("device_name")
    public String getDeviceName() {
        return device_name;
    }

    /**
     *
     * @param deviceName
     * The device_name
     */
    @JsonProperty("device_name")
    public void setDeviceName(String deviceName) {
        this.device_name = deviceName;
    }

    /**
     *
     * @return
     * The deviceDisplay
     */
    @JsonProperty("device_display")
    public List<Integer> getDeviceDisplay() {
        return device_display;
    }

    /**
     *
     * @param deviceDisplay
     * The device_display
     */
    @JsonProperty("device_display")
    public void setDeviceDisplay(List<Integer> deviceDisplay) {
        this.device_display = deviceDisplay;
    }

    /**
     *
     * @return
     * The deviceIdentifier
     */
    @JsonProperty("device_identifier")
    public String getDeviceIdentifier() {
        return device_identifier;
    }

    /**
     *
     * @param deviceIdentifier
     * The device_identifier
     */
    @JsonProperty("device_identifier")
    public void setDeviceIdentifier(String deviceIdentifier) {
        this.device_identifier = deviceIdentifier;
    }

    /**
     *
     * @return
     * The localTime
     */
    @JsonProperty("local_time")
    public String getLocalTime() {
        return local_time;
    }

    /**
     *
     * @param localTime
     * The local_time
     */
    @JsonProperty("local_time")
    public void setLocalTime(String localTime) {
        this.local_time = localTime;
    }

    /**
     *
     * @return
     * The locale
     */
    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    /**
     *
     * @param locale
     * The locale
     */
    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }



}
