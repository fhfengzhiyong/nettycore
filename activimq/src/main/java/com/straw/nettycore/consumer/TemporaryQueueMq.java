package com.straw.nettycore.consumer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 8/28/2017.
 */
public class TemporaryQueueMq implements Runnable{
    String threadName;

    public static void main(String[] args) {
        new Thread(new TemporaryQueueMq("Q1")).start();
        new Thread(new TemporaryQueueMq("Q2")).start();
        new Thread(new TemporaryQueueMq("Q3")).start();
    }

    public TemporaryQueueMq(String threadName){
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
            destination = session.createTemporaryQueue();

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
