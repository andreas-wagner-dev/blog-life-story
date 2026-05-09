package manuscript.stage;

import java.util.ArrayList;
import java.util.List;

import manuscript.Media;
import manuscript.Name;

public abstract class Multimedia extends Media.Default {

	private Name name;
	protected List<Media> elements = new ArrayList<>(0);

	public Multimedia(Name name) {
		this.name = name;
	}

	public Name name() {
		return name;
	}

	public void add(Media media) {
		elements.add(media);
	}

	public abstract void render();
}
