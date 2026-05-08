package manuscript.backstage.phone;

import java.util.function.Consumer;

import manuscript.backstage.Channel;

public class Phone implements Channel<String> {
	
	private String phoneNummer;
	private Consumer<String> reciever;

	public Phone(String phoneNummer) {
		this.phoneNummer = phoneNummer;
		System.out.println("📡 Verbindung wird aufgebaut: " + this.phoneNummer);
	}

	@Override
	public void receive(Consumer<String> reciever) {
		this.reciever = reciever;
	}


	@Override
	public void publish(String message) {
		System.out.println("📡 Nachricht wird ausgetauscht: " + message);
		reciever.accept("OK...");
	}
}
