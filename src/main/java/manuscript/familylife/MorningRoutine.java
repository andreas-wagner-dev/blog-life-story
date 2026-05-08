package manuscript.familylife;

import manuscript.Scene;
import manuscript.character.Groom;
import manuscript.character.Bride;
import manuscript.character.Newborn;

/**
 * Morning routine scene.
 */
public class MorningRoutine implements Scene {
    
    private final Groom father;
    private final Bride mother;
    private final Newborn child;
    
    public MorningRoutine(Groom father, Bride mother, Newborn child) {
        this.father = father;
        this.mother = mother;
        this.child = child;
    }
    
    @Override
    public void execute() {
        System.out.println("\n☀️ === FAMILY MORNING ROUTINE ===");
        System.out.println("⏰ " + father.name() + " prepares breakfast..");
        System.out.println("🍼 " + mother.name() + " feeds " + child.name() + ".");
        child.perform();
        System.out.println("☀️ === MORNING ROUTINE COMPLETED ===\n");
    }
}