package manuscript.wedding;

import manuscript.Media;

/** Lädt das Video in den Arbeitsspeicher. */
public class VideoCanvas extends Media.Default {

	@Override
	public Media with(String name, String value) {
		super.with(name, value);
		System.out.println("📺 Video läuft...");
		return this;
	}

}