package manuscript.outfit;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Outfit;
import manuscript.backstage.phone.Headset;
import manuscript.backstage.phone.Phone;

public class GroomWithPhone extends Outfit implements Headset {

	private Phone phone;

	public GroomWithPhone(Actor actor, Phone phone) {
		super(actor);
		this.phone = phone;
		this.phone.receive(this);
	}

	public void call(String message) {
		System.out.println("📞 Anrufen der Band 🎼...");
		phone.publish(message);
	}

	@Override
	public void accept(String message) {
		System.out.println("📞 Bestätigung von der Band 🎹: " + message);
	}

	@Override
	public void speak(Media spaek) {
		decoratedActor.speak(spaek);
	}

}
