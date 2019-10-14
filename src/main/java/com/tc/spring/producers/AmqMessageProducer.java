package com.tc.spring.producers;


import com.tc.spring.contracts.MessageProducer;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AmqMessageProducer implements MessageProducer {

    private String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    @Override
    public void send(String messageText) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("messageQueue");

            javax.jms.MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage(messageText);
            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }




    }
}
