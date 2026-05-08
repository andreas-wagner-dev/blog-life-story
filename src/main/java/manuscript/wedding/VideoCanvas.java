package manuscript.wedding;

import manuscript.Media;

/** Canvas for a video film. */
public class VideoCanvas extends Media.Default {

	@Override
	public Media with(String name, String value) {
		super.with(name, value);
		System.out.println("📺 Video playing...");
		return this;
	}

}