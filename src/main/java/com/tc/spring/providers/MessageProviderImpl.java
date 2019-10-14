package com.tc.spring.providers;

import com.tc.spring.contracts.MessageProvider;

public class MessageProviderImpl implements MessageProvider {

    public String getMessage() {
        return "Hello Spring";
    }
}
