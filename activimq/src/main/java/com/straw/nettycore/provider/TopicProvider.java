package com.straw.nettycore.provider;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 8/28/2017.
 */
public class TopicProvider {
    public static void main(String[] args) {
        provider();
    }

    private static void provider() {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageProducer messageProducer;
        try {
            connectionFactory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_USER,
                    ActiveMQConnection.DEFAULT_PASSWORD,
                    "tcp://192.168.2.100:61616"
            );
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("testTopic");
            messageProducer = session.createProducer(destination);
            sendMsg(session,messageProducer);
            session.commit();
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

    private static void sendMsg(Session session, MessageProducer messageProducer) throws JMSException {
        TextMessage message =session.createTextMessage("ActiveMQ发送的消息" );
        messageProducer.send(message);
        System.out.println("消息发送完成");
    }
}
