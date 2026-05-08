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
        System.out.println("\n💍 === THE RINGEXCHANGE ===");
        RingBasket ringBasket = new RingBasket();
        groom.giveRing(ringBasket);
        bride.receiveRing(ringBasket);
        bride.giveRing(ringBasket);
        groom.receiveRing(ringBasket);
        System.out.println("💍 === RINGS WERE EXCHANGED ===\n");
    }
}