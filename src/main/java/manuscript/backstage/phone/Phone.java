package manuscript.backstage.phone;

import java.util.function.Consumer;

import manuscript.backstage.Channel;

/**
 * Connects the telecommunication severe.
 */
public class Phone implements Channel<String> {
	
	private String phoneNummer;
	private Consumer<String> reciever;

	public Phone(String phoneNummer) {
		this.phoneNummer = phoneNummer;
		System.out.println("📡 Establishing connection: " + this.phoneNummer);
	}

	@Override
	public void receive(Consumer<String> reciever) {
		this.reciever = reciever;
	}


	@Override
	public void publish(String message) {
		System.out.println("📡 Message is being exchanged: " + message);
		reciever.accept("OK...");
	}
}
