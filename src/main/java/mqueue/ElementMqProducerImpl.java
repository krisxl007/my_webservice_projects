package mqueue;

import constant.QueryValueConstant;
import mqueue.bean.ElementMqBean;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

import javax.jms.*;

public class ElementMqProducerImpl implements MqProducer {

    private static final Logger LOGGER = Logger.getLogger(ElementMqProducerImpl.class);

    @Override
    public String produce(int value) {
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createQueue("Element-Queue");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            ElementMqBean bean = new ElementMqBean();
            bean.setValue(value);
            producer.send(session.createObjectMessage(bean));

            LOGGER.info("Values have been sent to jms queue!");
            producer.close();

            return QueryValueConstant.OK;
        } catch (JMSException e) {
            LOGGER.error(e);
            return QueryValueConstant.NOT_OK;
        }
    }
}
