package manuscript.backstage;

import java.util.function.Consumer;

/**
 * Access to a communication channel.
 * @param <T> type of transfer data object
 */
public interface Channel<T> {

	void subscribe(Consumer<T> subscriber);

	void publish(T message);
}
