package com.tc.spring.contracts;

import javax.jms.JMSException;

public interface MessageRenderer {
    void render() throws JMSException;
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
