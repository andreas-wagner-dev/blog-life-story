package manuscript.wedding;

import manuscript.Media;
import manuscript.Scene;

public class LoveStoryFlashback implements Scene {
    
    private final Video video;
    private final Media screen;
    
    public LoveStoryFlashback(Video video, Media screen) {
        this.video = video;
        this.screen = screen;
    }
    
    @Override
    public void execute() {
        System.out.println("\n📽️ === LOVE STORY - A LOOK BACK ===");
        video.play(screen);
        System.out.println("📽️ === END OF LOOK BACK ===\n");
    }
}