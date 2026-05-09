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
		this.phone.subscribe(this);
	}

	public void call(String message) {
		System.out.println("📞 Calling the Band 🎼...");
		phone.publish(message);
	}

	@Override
	public void accept(String message) {
		System.out.println("📞 Confirmation from the band 🎹: " + message);
	}

	@Override
	public void speak(Media spaek) {
		decoratedActor.speak(spaek);
	}

}
