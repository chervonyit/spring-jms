package com.tc.spring.contracts;

import javax.jms.JMSException;

public interface MessageProvider {
    String getMessage() throws JMSException;
}
