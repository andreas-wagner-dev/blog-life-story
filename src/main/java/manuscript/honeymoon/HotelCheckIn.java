package manuscript.honeymoon;

import manuscript.Scene;
import manuscript.Actor;

public class HotelCheckIn implements Scene {
    
    private final Actor groom;
    private final Actor bride;
    
    public HotelCheckIn(Actor groom, Actor bride) {
        this.groom = groom;
        this.bride = bride;
    }
    
    @Override
    public void execute() {
        System.out.println("\n🏨 === HOTEL CHECK-IN ===");
        System.out.println("🗝️ " + groom.name() + " and " + bride.name() + " move into their room.");
        System.out.println("🏨 === CHECK-IN COMPLETED ===\n");
    }
}