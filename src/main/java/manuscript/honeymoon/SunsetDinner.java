package manuscript.honeymoon;

import manuscript.Scene;
import manuscript.Actor;

public class SunsetDinner implements Scene {
    
    private final Actor groom;
    private final Actor bride;
    
    public SunsetDinner(Actor groom, Actor bride) {
        this.groom = groom;
        this.bride = bride;
    }
    
    @Override
    public void execute() {
        System.out.println("\n🌅 === ROMANTISCHES ABENDESSEN BEI SONNENUNTERGANG ===");
        System.out.println("🍷 " + groom.name() + " und " + bride.name() + " genießen ein köstliches Dinner.");
        System.out.println("🌅 === ABENDESSEN BEENDET ===\n");
    }
}