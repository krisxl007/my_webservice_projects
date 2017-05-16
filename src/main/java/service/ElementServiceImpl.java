package service;

import constant.QueryValueConstant;
import dao.ElementDao;
import mqueue.ElementMqProducerImpl;
import mqueue.MqProducer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ElementServiceImpl implements ElementService{

    private static final Logger LOGGER = Logger.getLogger(ElementServiceImpl.class);

    @Autowired
    private ElementDao elementDaoImpl;

    @Transactional
    @Override
    public String push(int value1, int value2) {
        LOGGER.info("Requested push(): value1=" + value1 + ",value2=" + value2);

        MqProducer producer = new ElementMqProducerImpl();
        String value1Status = producer.produce(value1);
        String value2Status = producer.produce(value2);

        return !QueryValueConstant.NOT_OK.equalsIgnoreCase(value1Status)
                &&  !QueryValueConstant.NOT_OK.equalsIgnoreCase(value2Status)
                ? QueryValueConstant.OK
                : "Value1: " + value1Status + " Value2: " + value2Status;
    }

    @Transactional
    @Override
    public List<String> list() {
        LOGGER.info("Requested list()");
        return elementDaoImpl.getAll();
    }

    @Transactional
    @Override
    public String getById(int id) {
        LOGGER.info("Requested getById(): id=" + id);
        return elementDaoImpl.getById(id);
    }

}
