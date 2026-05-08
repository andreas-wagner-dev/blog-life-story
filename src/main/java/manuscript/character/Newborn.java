package manuscript.character;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Name;

/**  
 * The newborn is a new character who appears during the family story.  
 */  
public class Newborn implements Actor {
    
    private final Name name;
    
    public Newborn(String name) {
        this.name = new Name(name);
    }
    
    @Override
    public Name name() {
        return name;
    }
    
    @Override
    public void perform() {
        System.out.println("👶 " + name + " smiles cheerfully.");
    }

     /** Baby cry.*/
    public void speak(Media media) {
        String value = name.value();
		media.with("role", "Newborn")
            .with("name", value)
            .with("text", "😭 " + name + " cries loudly!");
    }
}