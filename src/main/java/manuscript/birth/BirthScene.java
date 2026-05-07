package manuscript.birth;

import manuscript.Scene;
import manuscript.character.Bride;
import manuscript.character.Newborn;
 
public class BirthScene implements Scene {
    
    private final Bride mother;
    private final Newborn baby;
    private final Hospital hospital;
    
    public BirthScene(Bride mother, Newborn baby, Hospital hospital) {
        this.mother = mother;
        this.baby = baby;
        this.hospital = hospital;
    }
    
    @Override
    public void execute() {
        System.out.println("\n🤰 === DIE GEBURT ===");
        hospital.admitPatient(mother.name().value());
        hospital.deliverBaby(baby.name().value());
        baby.cry();
        System.out.println("🤰 === GEBURT ERFOLGREICH ===\n");
    }
}