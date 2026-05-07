package manuscript.character;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Name;

public class Bride implements Actor {

	private final Name name;
	private boolean hasRing = false;

	public Bride(String name) {
		this.name = new Name(name);
	}

	@Override
	public Name name() {
		return name;
	}

	@Override
	public void perform() {
		System.out.println("💍 " + name + " gibt ihr Eheversprechen ab.");
	}

	/**
	 * Die Braut empfängt den Ring.
	 */
	public void receiveRing() {
		if (hasRing) {
			throw new IllegalStateException("Die Braut trägt bereits einen Ring!");
		}
		System.out.println("💍 " + name + " nimmt den Trauring entgegen.");
		hasRing = true;
	}

	/**
	 * Die Braut "spricht" das "Ja-Wort".
	 */
	public void speak(Media media) {
		media.with("role", "Bride")
		.with("name", name.value())
		.with("text", "Yes, I will...")
		.with("hasRing", hasRing);
	}
}