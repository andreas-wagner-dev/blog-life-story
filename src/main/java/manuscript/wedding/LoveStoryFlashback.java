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
        System.out.println("\n📽️  === LIEBESGESCHICHTE - RÜCKBLICK ===");
        video.play(screen);
        System.out.println("📽️  === ENDE DES RÜCKBLICKS ===\n");
    }
}