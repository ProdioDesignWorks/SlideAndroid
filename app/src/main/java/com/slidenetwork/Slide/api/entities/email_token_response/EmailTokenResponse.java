package com.slidenetwork.Slide.api.entities.email_token_response;

import java.util.HashMap;
import java.util.Map;

//-----------------------------------com.example.Example.java-----------------------------------


public class EmailTokenResponse {

    private EmailTokenData data;
    private Meta meta;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The data
     */
    public EmailTokenData getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(EmailTokenData data) {
        this.data = data;
    }

    /**
     *
     * @return
     * The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     *
     * @param meta
     * The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
//-----------------------------------com.example.Links.java-----------------------------------

//-----------------------------------com.example.Message.java-----------------------------------


//-----------------------------------com.example.Meta.java-----------------------------------


