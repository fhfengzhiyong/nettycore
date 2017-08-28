package com.straw.nettycore.provider;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 8/28/2017.
 */
public class QueueProvider {
    public static void main(String[] args) {
        provide();
    }

    private static void provide() {
        ActiveMQConnectionFactory connectionFactory;
        ActiveMQConnection connection = null;
        Session session;
        Destination destination;
        MessageProducer producer;
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://192.168.2.100:61616"
        );
        try {
            connection = (ActiveMQConnection) connectionFactory.createConnection();
            connection.setSendAcksAsync(false);


            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("testQueue");
            producer = session.createProducer(destination);
            for (int i=0;i<20;i++){
                sendMessage(session,producer,i);
                session.commit();
                Thread.sleep(500);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection == null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void sendMessage(Session session, MessageProducer producer,int i) throws JMSException {
        TextMessage message = session.createTextMessage("我是["+i+"]");
        producer.send(message);
    }
}
