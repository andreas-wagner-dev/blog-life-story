package manuscript.backstage;

import java.util.function.Consumer;

/**
 * Access to a communication channel.
 * @param <T> type of transfer data object
 */
public interface Channel<T> {

	void receive(Consumer<T> reciever);

	void publish(T message);
}
