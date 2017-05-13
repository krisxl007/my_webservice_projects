package mqueue;

public class ElementMqMonitor {



    public void start() {
        MqConsumer consumer = new ElementMqConsumerImpl();
        consumer.consume();
    }
}
