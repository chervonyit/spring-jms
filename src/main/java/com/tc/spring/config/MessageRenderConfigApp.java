package com.tc.spring.config;

import com.tc.spring.contracts.MessageProvider;
import com.tc.spring.contracts.MessageRenderer;
import com.tc.spring.providers.MessageProviderImpl;
import com.tc.spring.renderers.StandartOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageRenderConfigApp {

    @Bean
    public MessageRenderer renderer(){
        MessageRenderer renderer = new StandartOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }

    @Bean
    public MessageProvider provider(){
        return new MessageProviderImpl();
    }
}
