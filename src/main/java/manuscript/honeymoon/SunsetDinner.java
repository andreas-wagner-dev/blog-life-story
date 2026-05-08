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
        System.out.println("\n🌅 === ROMANTIC DINNER ABENDESSEN AT SUNSET ===");
        System.out.println("🍷 " + groom.name() + " and " + bride.name() + " enjoy a delicious dinner.");
        System.out.println("🌅 === DINNER ENDED ===\n");
    }
}