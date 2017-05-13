package mqueue;

/**
 * Message queue producer interface
 */
public interface MqProducer {
    String produce(int value);
}
