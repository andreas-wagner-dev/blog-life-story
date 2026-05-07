package manuscript.wedding;

import manuscript.Scene;
import manuscript.character.Groom;
import manuscript.character.Bride;

public class WeddingCeremony implements Scene {
	
    private final Groom groom;
    private final Bride bride;
    private final Scene ringExchange; // Die Zeremonie beinhaltet den Ringtausch

    public WeddingCeremony(Groom groom, Bride bride, Scene ringExchange) {
        this.groom = groom;
        this.bride = bride;
        this.ringExchange = ringExchange;
    }

    @Override
    public void execute() {
        System.out.println("\n💒 === DIE TRAUUNGSZEREMONIE BEGINNT ===");
        
        // Die Akteure geben ihr Versprechen ab
        groom.perform();
        bride.perform();
        
        // Der Höhepunkt: Der Ringtausch wird als Unterszene aufgerufen
        ringExchange.execute();
        
        System.out.println("💒 === DIE TRAUUNG IST VOLLZOGEN ===\n");
    }
}