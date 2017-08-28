package com.straw.nettycore.consumer;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 8/28/2017.
 */
public class TopicConsumer implements Runnable {
    private String threadName;

    public static void main(String[] args) {
        System.out.println();
        System.out.println("1");
        TopicConsumer TopicConsumer =new TopicConsumer("T1");
        TopicConsumer TopicConsumer1 =new TopicConsumer("T2");
        TopicConsumer TopicConsumer2 =new TopicConsumer("T3");

        new Thread(TopicConsumer).start();
        new Thread(TopicConsumer1).start();
        new Thread(TopicConsumer2).start();





    }

    public TopicConsumer(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageConsumer messageConsumer;
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://192.168.2.100:61616"
        );
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("testTopic");
            messageConsumer = session.createConsumer(destination);
            while (true) {
                TextMessage message = (TextMessage) messageConsumer.receive(5000);
                if (message != null) {
                    System.out.println("["+threadName+"] 接受到消息==>： " + message);
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection == null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
