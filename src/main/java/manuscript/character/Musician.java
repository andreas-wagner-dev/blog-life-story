package manuscript.character;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Name;

/**
 * Musician role.
 */
public class Musician implements Actor {
	
	private final Name name;

	public Musician(String name) {
		this.name = new Name(name);
	}

	@Override
	public Name name() {
		return name;
	}

	@Override
	public void perform() {
		System.out.println("🧍‍ " + name + " play music.");
	}

	@Override
	public void speak(Media media) {
		media.with("role", "Musician")
		.with("name", name.value())
		.with("text", "🎤💬 " + name + " singing a song!");
	}
}