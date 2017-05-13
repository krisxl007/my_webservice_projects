package mqueue;

import mqueue.bean.ElementMqBean;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ElementMqProducerImpl implements MqProducer {

    ConnectionFactory connectionFactory;
    Connection connection;
    Session session;
    Destination destination;
    MessageProducer producer;

    @Override
    public void produce(int value) {
        try {
            connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            destination = session.createQueue("Element-Queue");
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            ElementMqBean bean = new ElementMqBean();
            bean.setValue(value);
            producer.send(session.createObjectMessage(bean));
            System.out.println("send!");
            producer.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
