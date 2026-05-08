package manuscript.birth;

import manuscript.Media;
import manuscript.Scene;
import manuscript.character.Bride;
import manuscript.character.Newborn;
 
/**
 * Birth scene.
 */
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
        System.out.println("\n🤰 === THE BIRTH ===");
        hospital.admitPatient(mother.name().value());
        hospital.deliverBaby(baby.name().value());
    	Media.Air air = new Media.Air();
        baby.speak(air);
        System.out.println(air.toString());
        System.out.println("🤰 === BIRTH SUCCESSFUL ===\n");
    }
}