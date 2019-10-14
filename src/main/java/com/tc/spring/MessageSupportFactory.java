package com.tc.spring;

import com.tc.spring.contracts.MessageProvider;
import com.tc.spring.contracts.MessageRenderer;

import java.io.IOException;
import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    private Properties props;
    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory(){
        props = new Properties();

        try{
            props.load(this.getClass().getResourceAsStream("/msf.properties"));

            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");

            renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Constructor");
    }

    static{
        System.out.println("static block");
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance(){
        return instance;
    }

    public MessageProvider getMessageProvider(){
        return provider;
    }

    public MessageRenderer getMessageRenderer(){
        return renderer;
    }
}
