package manuscript.wedding.video;

import manuscript.Media;
import manuscript.wedding.Video;

public class RealVideo implements Video {
    
    private final String filename;
    private boolean loaded = false;
    
    public RealVideo(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void load() {
        if (!loaded) {
            System.out.println("📼 Lade Video: " + filename + " (dies dauert einen Moment...)");
            // Simuliere schwere Lade-Operationen
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            loaded = true;
        }
    }
    
	@Override
	public void play(Media screen) {
        if (!loaded) {
            load();
        }
        System.out.println("▶️ Spiele Video ab: " + filename);
		screen.with("content", filename);
		
	}
}