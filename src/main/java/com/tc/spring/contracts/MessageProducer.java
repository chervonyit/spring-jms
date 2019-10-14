package com.tc.spring.contracts;

import javax.jms.JMSException;

public interface MessageProducer {
    void send(String message) throws JMSException;
}
