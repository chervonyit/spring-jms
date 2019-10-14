package com.tc.spring;

import com.tc.spring.config.MessageRenderConfigApp;
import com.tc.spring.contracts.MessageProducer;
import com.tc.spring.contracts.MessageProvider;
import com.tc.spring.contracts.MessageRenderer;
import com.tc.spring.providers.MessageProviderImpl;
import com.tc.spring.renderers.StandartOutMessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.JMSException;

public class MainClass {

    public static void main(String[] args) throws JMSException {
       /* MessageProvider provider = new MessageProviderImpl();
        MessageRenderer renderer = new StandartOutMessageRenderer();

        renderer.setMessageProvider(provider);
        renderer.render();*/

      /*  MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();

        mr.setMessageProvider(mp);
        mr.render();*/

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/app-context.xml");
        MessageProducer mr = ctx.getBean("amqProducer", MessageProducer.class);
        MessageProvider mp = ctx.getBean("amqProvider", MessageProvider.class);
        try {
            mr.send("new message 4");
        } catch (JMSException e) {
            e.printStackTrace();
        }

        mp.getMessage();

       /*ApplicationContext ctx = new AnnotationConfigApplicationContext(MessageRenderConfigApp.class);
       MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
       mr.render();*/

    }
}
