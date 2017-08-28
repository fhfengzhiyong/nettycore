package com.straw.nettycore.consumer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.swing.*;

/**
 * Created by Administrator on 8/28/2017.
 */
public class QueueConsumer  implements Runnable{
    String threadName;

    public static void main(String[] args) {
        new Thread(new QueueConsumer("Q1")).start();
        new Thread(new QueueConsumer("Q2")).start();
        new Thread(new QueueConsumer("Q3")).start();
    }

    public QueueConsumer(String threadName){
        this.threadName = threadName;
    }
    @Override
    public void run() {
        ActiveMQConnectionFactory connectionFactory;
        ActiveMQConnection connection = null;
        Session session;
        Destination destination;
        MessageConsumer consumer;

        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://192.168.2.100:61616"
        );
        try {
            connection = (ActiveMQConnection) connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("testQueue");
            consumer = session.createConsumer(destination);
            while (true){
                TextMessage message = (TextMessage) consumer.receive(500000);
                if (message != null) {
                    System.out.println("["+threadName+"] 接受到消息： "+ message.getText()+" (等待10s)");
                    Thread.sleep(10000);
                    System.out.println(threadName+"  休息结束");
                }
            }
        } catch (Exception e) {
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
