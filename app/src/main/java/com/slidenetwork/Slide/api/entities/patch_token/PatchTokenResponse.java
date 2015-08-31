package com.slidenetwork.Slide.api.entities.patch_token;


import com.slidenetwork.Slide.api.entities.email_token_response.Meta;

public class PatchTokenResponse {

    private PatchTokenResponseData data;
    private Meta meta;

    /**
     *
     * @return
     * The data
     */
    public PatchTokenResponseData getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(PatchTokenResponseData data) {
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


}
