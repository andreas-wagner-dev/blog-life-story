package manuscript.wedding.video;

import manuscript.Media;
import manuscript.wedding.Video;

public class LazyVideo implements Video {

	private final String filename;
	private RealVideo realVideo;
	private boolean initialized = false;

	public LazyVideo(String filename) {
		this.filename = filename;
	}

	@Override
	public void load() {
		if (!initialized) {
			realVideo = new RealVideo(filename);
		}
		initialized = true;
		realVideo.load();
	}
	
	@Override
	public void play(Media screen) {
		if (!initialized) {
			System.out.println("🎬 Proxy bereitet Video vor...");
			load();
		}
		realVideo.play(screen);
	}
	
	@Override
	public void play() {
		if (!initialized) {
			System.out.println("🎬 Proxy bereitet Video vor...");
			load();
		}
		realVideo.play();
	}


}