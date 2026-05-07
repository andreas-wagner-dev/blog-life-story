package manuscript.wedding;

import manuscript.Scene;
import manuscript.backstage.Payer;

public class PayTheBand implements Scene {
    
    private final Payer payer;
    private final double amount;
    
    public PayTheBand(Payer payer, double amount) {
        this.payer = payer;
        this.amount = amount;
    }
    
    @Override
    public void execute() {
        System.out.println("\n🎵 === DIE BAND WIRD BEZAHLT ===");
        payer.pay(amount);
        System.out.println("🎵 === ZAHLUNG ABGESCHLOSSEN ===\n");
    }
}