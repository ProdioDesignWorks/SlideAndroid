package com.slidenetwork.Slide.api.entities.patch_token;


public class PatchTokenRequestData {


    private String type;
    private String auth_method;
    private String auth_token;
    private String email;

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
     * The auth_method
     */
    public String getAuth_method() {
        return auth_method;
    }

    /**
     *
     * @param auth_method
     * The auth_method
     */
    public void setAuth_method(String auth_method) {
        this.auth_method = auth_method;
    }

    /**
     *
     * @return
     * The auth_token
     */
    public String getAuth_token() {
        return auth_token;
    }

    /**
     *
     * @param auth_token
     * The auth_token
     */
    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }



}