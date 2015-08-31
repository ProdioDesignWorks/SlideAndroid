package com.slidenetwork.Slide.api.entities.email_token_response;

//-----------------------------------com.example.User_detail.java-----------------------------------
public class User_detail {

    private String email;
    private String email_subject;
    private String message;
    private String title;

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

    /**
     *
     * @return
     * The email_subject
     */
    public String getEmail_subject() {
        return email_subject;
    }

    /**
     *
     * @param email_subject
     * The email_subject
     */
    public void setEmail_subject(String email_subject) {
        this.email_subject = email_subject;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }


}
