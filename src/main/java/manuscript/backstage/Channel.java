package manuscript.backstage;

import java.util.function.Consumer;

public interface Channel<T> {

	void receive(Consumer<T> reciever);

	void publish(T message);
}
