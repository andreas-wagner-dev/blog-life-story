package manuscript.character;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Name;

/**
 * Der Bräutigam ist einer der Hauptcharaktere in der Hochzeitsgeschichte.
 */
public class Groom implements Actor {

	private final Name name;
	private boolean hasRing;

	public Groom(String name) {
		this.name = new Name(name);
	}

	@Override
	public Name name() {
		return name;
	}

	@Override
	public void perform() {
		System.out.println("💍 " + name + " exchanges his wedding vows.");
	}

	/**
	 * The groom presents the ring.
	 */
	public void giveRing(Media ringBasket) {
		ringBasket.with("bride", "Wedding-Ring");
		System.out.println("💍 " + name + " presents the " + ringBasket + ".");
	}
	
	/**
	 * The groom receives the ring.
	 * 
	 * @param ringBasket basket
	 */
	public void receiveRing(Media ringBasket) {
		if (hasRing) {
			throw new IllegalStateException("The groom is already wearing a ring!");
		}
		System.out.println("💍 " + name + " take the " + ringBasket + ".");
		hasRing = true;
	}
	
	public void speak(Media media) {
		media.with("role", "Groom")
		.with("name", name.value())
		.with("text", "Yes, I will...")
		.with("hasRing", hasRing);
	}

}