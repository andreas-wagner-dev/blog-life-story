package manuscript.stage.accessory;

import java.util.Arrays;
import java.util.List;

import manuscript.Media;

public class CinematicGrid {

	private List<Media> columns;

	public CinematicGrid(Media... columns) {
		this.columns = Arrays.asList(columns);
	}

	public void render() {
		System.out.println("🎞️ [Cinematic Grid is rendered with " + columns + " columns]");
	}
}