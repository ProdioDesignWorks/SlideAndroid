package com.slidenetwork.Slide.api.entities.email_token_response;

import java.util.ArrayList;
import java.util.List;


public class Meta {

    private List<Message> messages = new ArrayList<Message>();

    /**
     *
     * @return
     * The messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     *
     * @param messages
     * The messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }



}
