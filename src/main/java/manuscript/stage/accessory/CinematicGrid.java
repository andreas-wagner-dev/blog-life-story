package manuscript.stage.accessory;

import manuscript.Media;
import manuscript.Name;
import manuscript.stage.Multimedia;

public class CinematicGrid extends Multimedia {

	public CinematicGrid() {
		super(new Name("CinematicGrid"));
	}

	public void render() {
		System.out.println("📺 Render " + name().value());
		System.out.print(toString());
	}

	@Override
	public String toString() {
		String text = "";
		for (Media media : elements) {
			text = text + "📺 Render " + media.toString() + "\n";
		}
		return text;
	}
}