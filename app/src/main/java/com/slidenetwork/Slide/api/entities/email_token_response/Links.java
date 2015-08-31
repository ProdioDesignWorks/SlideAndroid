package com.slidenetwork.Slide.api.entities.email_token_response;


public  class Links {

       private String self;
       private String device;
       private String user;

       /**
        *
        * @return
        * The self
        */
       public String getSelf() {
           return self;
       }

       /**
        *
        * @param self
        * The self
        */
       public void setSelf(String self) {
           this.self = self;
       }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}

