package com.slidenetwork.Slide.api.entities.email_token_response;

import java.util.HashMap;
import java.util.Map;


public class Message {

   private String code;
   private String detail;
   private String email;
   private String email_subject;
   private String source;
   private String title;
   private User_detail user_detail;
   private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    /**
    *
    * @return
    * The code
    */
   public String getCode() {
       return code;
   }

   /**
    *
    * @param code
    * The code
    */
   public void setCode(String code) {
       this.code = code;
   }

   /**
    *
    * @return
    * The detail
    */
   public String getDetail() {
       return detail;
   }

   /**
    *
    * @param detail
    * The detail
    */
   public void setDetail(String detail) {
       this.detail = detail;
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
    * The source
    */
   public String getSource() {
       return source;
   }

   /**
    *
    * @param source
    * The source
    */
   public void setSource(String source) {
       this.source = source;
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

   /**
    *
    * @return
    * The user_detail
    */
   public User_detail getUser_detail() {
       return user_detail;
   }

   /**
    *
    * @param user_detail
    * The user_detail
    */
   public void setUser_detail(User_detail user_detail) {
       this.user_detail = user_detail;
   }

   public Map<String, Object> getAdditionalProperties() {
       return this.additionalProperties;
   }

   public void setAdditionalProperty(String name, Object value) {
       this.additionalProperties.put(name, value);
   }

}
