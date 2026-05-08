package manuscript.character;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Name;

/**
 * Guest role.
 */
public class Guest implements Actor {

	private final Name name;

	public Guest(String name) {
		this.name = new Name(name);
	}

	@Override
	public Name name() {
		return name;
	}

	@Override
	public void perform() {
		System.out.println("🧍‍♂️" + name + " lächelt fröhlich.");
	}

	/**
	 * Guest clap.
	 */
	public void clap() {
		Media.Air air = new Media.Air();
		speak(air);
		System.out.println(air.toString());
	}

	/**
	 * Congratulations and applause from the guest.
	 */
	public void speak(Media media) {
		media.with("role", "Guest")
		.with("name", name.value())
		.with("text", "💬 " + name + " congratulations!")
	    .with("action", "👏 " + name + " applaud!");
	}
}