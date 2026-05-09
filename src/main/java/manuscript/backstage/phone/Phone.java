package manuscript.backstage.phone;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import manuscript.backstage.Channel;

/**
 * Connects the telecommunication severe.
 */
public class Phone implements Channel<String> {

	private String phoneNummer;
	private List<Consumer<String>> subscribers = new ArrayList<>(0);

	public Phone(String phoneNummer) {
		this.phoneNummer = phoneNummer;
		System.out.println("📞 Phone ready: " + this.phoneNummer);
	}

	@Override
	public void subscribe(Consumer<String> subscriber) {
		this.subscribers.add(subscriber);
	}

	@Override
	public void publish(String message) {
		System.out.println("📞 Sending message: " + message);
		subscribers.forEach(subscriber -> subscriber.accept(message));
	}
}
