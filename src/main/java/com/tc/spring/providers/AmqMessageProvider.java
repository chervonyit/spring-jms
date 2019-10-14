package com.tc.spring.providers;

import com.tc.spring.contracts.MessageProvider;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;
import java.util.Enumeration;

public class AmqMessageProvider implements MessageProvider {

    private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    private ActiveMQQueue destination = new ActiveMQQueue("messageQueue");

    @Override
    public String getMessage() throws JMSException {
        Connection connection = null;
        try{
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            connection.start();

            QueueBrowser queueBrowser = session.createBrowser(destination);
            Enumeration enumeration = queueBrowser.getEnumeration();

            while(enumeration.hasMoreElements()){
                TextMessage message = (TextMessage) enumeration.nextElement();
                System.out.println(message.getText());
            }
            queueBrowser.close();
            session.close();
        }catch(JMSException e){
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.close();
            }
        }
        return "Message consumed";
    }
}
