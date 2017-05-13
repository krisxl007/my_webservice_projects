package mqueue;

import dao.ElementDao;
import mqueue.bean.ElementMqBean;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.*;
import java.util.Optional;

@Component
public class ElementMqConsumerImpl implements MqConsumer {

    private static final Logger LOGGER = Logger.getLogger(ElementMqConsumerImpl.class);

    @Autowired
    private ElementDao elementDaoImpl;

    @Override
    @PostConstruct
    public void consume() {
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("Element-Queue");
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(message -> {
                try {
                    ElementMqBean bean = (ElementMqBean) ((ObjectMessage)message).getObject();
                    Optional.of(message).ifPresent(n -> elementDaoImpl.add(bean.getValue()));
                    System.out.println("Successfully add to DB, value= : " + bean.getValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
