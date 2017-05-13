package service;

import constant.QueryValueConstant;
import dao.ElementDao;
import mqueue.ElementMqProducerImpl;
import mqueue.MqProducer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ElementServiceImpl implements ElementService{

    private static final Logger LOGGER = Logger.getLogger(ElementServiceImpl.class);

    @Autowired
    private ElementDao elementDaoImpl;

    @Override
    public String push(int value1, int value2) {
        MqProducer producer = new ElementMqProducerImpl();
        String value1Status = producer.produce(value1);
        String value2Status = producer.produce(value2);
        LOGGER.info("Values have been push to jms queue!");
        return value1Status.equals(value2Status) ? QueryValueConstant.OK
                : "Value1: " + value1Status + " Value2: " + value2Status;
    }

    @Override
    public List<String> list() {
        return elementDaoImpl.getAll();
    }

    @Override
    public String getById(int id) {
        return elementDaoImpl.getById(id);
    }

}
