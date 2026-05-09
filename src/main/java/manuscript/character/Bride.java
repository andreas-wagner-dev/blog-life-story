package manuscript.character;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Name;

/**
 * The actor playing the bride.
 */
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
		System.out.println("💍 " + name + " recites her wedding vows..");
	}

	/**
	 * The bride presents the ring.
	 */
	public void giveRing(Media ringBasket) {
		ringBasket.with("groom-ring", "Wedding-Ring");
		System.out.println("💍 " + name + " hands over " + ringBasket + ".");
	}

	/**
	 * The bride receives the ring.
	 * 
	 * @param ringBasket basket
	 */
	public void receiveRing(Media ringBasket) {
		String ring = ringBasket.content("bride-ring");
		if (ring.isEmpty()) {
			throw new IllegalStateException("Wedding ring is missing!");
		}
		if (hasRing) {
			throw new IllegalStateException("The bride is already wearing a ring!");
		}
		System.out.println("💍 " + name + " take the " + ring + ".");
		hasRing = true;
	}

	/**
	 * The bride "says" her "I will."
	 */
	public void speak(Media media) {
		media.with("role", "Bride").with("name", name.value()).with("text", "Yes, I will...").with("hasRing", hasRing);
	}
}