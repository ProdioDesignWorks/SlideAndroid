package com.slidenetwork.Slide.api.entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
public class TokenRequest {

    @JsonProperty("data")
    private TokenRequestData data;

    /**
     *
     * @return
     * The data
     */
    @JsonProperty("data")
    public TokenRequestData getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    @JsonProperty("data")
    public void setData(TokenRequestData data) {
        this.data = data;
    }


}
