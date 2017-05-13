package service;

import mqueue.ElementMqProducerImpl;
import mqueue.MqProducer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementServiceImpl implements ElementService{

    private static final Logger LOGGER = Logger.getLogger(ElementServiceImpl.class);

    @Override
    public String push(int value1, int value2) {
        MqProducer producer = new ElementMqProducerImpl();
        producer.produce(value1);
        producer.produce(value2);
        return "ok";
    }

    @Override
    public List<String> list() {
        return null;
    }
}
