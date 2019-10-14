package com.tc.spring.renderers;

import com.tc.spring.contracts.MessageProvider;
import com.tc.spring.contracts.MessageRenderer;

import javax.jms.JMSException;

public class StandartOutMessageRenderer implements MessageRenderer {

    private MessageProvider provider;

    public void render() throws JMSException {
        if(provider == null){
            throw new RuntimeException("You must set the property provider of StandartOutMessageRenderer.class");
        }
        System.out.println(provider.getMessage());
    }

    public void setMessageProvider(MessageProvider provider) {
        this.provider = provider;
    }

    public MessageProvider getMessageProvider() {
        return this.provider;
    }
}
