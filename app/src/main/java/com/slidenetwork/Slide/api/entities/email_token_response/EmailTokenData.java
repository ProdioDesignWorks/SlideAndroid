package com.slidenetwork.Slide.api.entities.email_token_response;


public class EmailTokenData {


    private String id;
    private String access_token;
    private String refresh_token;
    private Boolean active;
    private String expires_at;
    private String updated_at;
    private String created_at;
    private String type;
    private String token_type;
    private Links links;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The access_token
     */
    public String getAccess_token() {
        return access_token;
    }

    /**
     *
     * @param access_token
     * The access_token
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    /**
     *
     * @return
     * The refresh_token
     */
    public String getRefresh_token() {
        return refresh_token;
    }

    /**
     *
     * @param refresh_token
     * The refresh_token
     */
    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    /**
     *
     * @return
     * The active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     *
     * @param active
     * The active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     *
     * @return
     * The expires_at
     */
    public String getExpires_at() {
        return expires_at;
    }

    /**
     *
     * @param expires_at
     * The expires_at
     */
    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
    }

    /**
     *
     * @return
     * The updated_at
     */
    public String getUpdated_at() {
        return updated_at;
    }

    /**
     *
     * @param updated_at
     * The updated_at
     */
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    /**
     *
     * @return
     * The created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     *
     * @param created_at
     * The created_at
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The token_type
     */
    public String getToken_type() {
        return token_type;
    }

    /**
     *
     * @param token_type
     * The token_type
     */
    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    /**
     *
     * @return
     * The links
     */
    public Links getLinks() {
        return links;
    }

    /**
     *
     * @param links
     * The links
     */
    public void setLinks(Links links) {
        this.links = links;
    }



}