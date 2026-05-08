package manuscript.familylife;

import manuscript.Scene;
import manuscript.character.Groom;
import manuscript.character.Newborn;

/**
 * Bedtime scene.
 */
public class Bedtime implements Scene {
    
    private final Groom father;
    private final Newborn child;
    
    public Bedtime(Groom father, Newborn child) {
        this.father = father;
        this.child = child;
    }
    
    @Override
    public void execute() {
        System.out.println("\n🌙 === BEDTIME STORY ===");
        System.out.println("📖 " + father.name() + " reads " + child.name() + " a story aloud.");
        child.perform();
        System.out.println("😴 " + child.name() + " falls asleep peacefully.");
        System.out.println("🌙 === GOOD NIGHT ===\n");
    }
}