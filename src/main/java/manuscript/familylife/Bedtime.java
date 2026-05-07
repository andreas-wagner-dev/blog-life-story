package manuscript.familylife;

import manuscript.Scene;
import manuscript.character.Groom;
import manuscript.character.Newborn;

public class Bedtime implements Scene {
    
    private final Groom father;
    private final Newborn child;
    
    public Bedtime(Groom father, Newborn child) {
        this.father = father;
        this.child = child;
    }
    
    @Override
    public void execute() {
        System.out.println("\n🌙 === GUTE-NACHT-GESCHICHTE ===");
        System.out.println("📖 " + father.name() + " liest " + child.name() + " eine Geschichte vor.");
        child.perform();
        System.out.println("😴 " + child.name() + " schläft friedlich ein.");
        System.out.println("🌙 === GUTE NACHT ===\n");
    }
}