package manuscript.character;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Name;
import manuscript.wedding.RingExchange.RingBasket;

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
		System.out.println("💍 " + name + " gibt sein Eheversprechen ab.");
	}

	/**
	 * Der Bräutigam überreicht den Ring.
	 * 
	 */
	public void giveRing(RingBasket ringBasket) {
		ringBasket.with("bride", "Wedding-Ring");
		System.out.println("💍 " + name + " überreicht den " + ringBasket + ".");
	}
	
	/**
	 * Die Bräutigam empfängt den Ring.
	 * 
	 * @param ringOfBride
	 */
	public void receiveRing(RingBasket ringBasket) {
		if (hasRing) {
			throw new IllegalStateException("Die Bräutigam trägt bereits einen Ring!");
		}
		System.out.println("💍 " + name + " nimmt den " + ringBasket + " entgegen.");
		hasRing = true;
	}
	
	/**
	 * Der Akteur artikuliert seine Identität. Er "spricht" zum Medium und übergibt
	 * seine fachlichen Details, ohne seine interne Struktur zu entblößen.
	 */
	public void speak(Media media) {
		media.with("role", "Groom")
		.with("name", name.value())
		.with("text", "Yes, I will...")
		.with("hasRing", hasRing);
	}

}