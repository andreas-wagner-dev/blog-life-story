package manuscript.character;

import manuscript.Actor;
import manuscript.Air;
import manuscript.Media;
import manuscript.Name;

/**  
 * Das Neugeborene ist ein neuer Charakter, der während der Familiengeschichte erscheint.  
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
        System.out.println("👶 " + name + " lächelt fröhlich.");
    }
    
    /**  
     * Das Baby weint.  
     */  
    public void cry() {
        Air air = new Air(); // default Medium
        speak(air);
        System.out.println(air.toString());
    }
    
     /**
     * Das Baby weint.
     */
    public void speak(Media media) {
        String value = name.value();
		media.with("role", "Newborn")
            .with("name", value)
            .with("text", "😭 " + name + " weint laut!");
    }
}