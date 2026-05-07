package manuscript.familylife;

import manuscript.Scene;
import manuscript.character.Groom;
import manuscript.character.Bride;
import manuscript.character.Newborn;

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
        System.out.println("\n☀️ === MORGENROUTINE DER FAMILIE ===");
        System.out.println("⏰ " + father.name() + " bereitet das Frühstück vor.");
        System.out.println("🍼 " + mother.name() + " füttert " + child.name() + ".");
        child.perform();
        System.out.println("☀️ === MORGENROUTINE ABGESCHLOSSEN ===\n");
    }
}