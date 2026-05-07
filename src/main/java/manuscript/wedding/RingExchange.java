package manuscript.wedding;

import manuscript.Scene;
import manuscript.character.Groom;
import manuscript.character.Bride;

public class RingExchange implements Scene {
    
    private final Groom groom;
    private final Bride bride;
    
    public RingExchange(Groom groom, Bride bride) {
        this.groom = groom;
        this.bride = bride;
    }
    
    @Override
    public void execute() {
        System.out.println("\n💍 === DER RINGTAUSCH ===");
        groom.giveRing();
        bride.receiveRing();
        System.out.println("💍 === RINGE WURDEN GETAUSCHT ===\n");
    }
}