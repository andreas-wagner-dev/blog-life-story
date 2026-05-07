package manuscript.character;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Name;

/**  
 * Der Bräutigam ist einer der Hauptcharaktere in der Hochzeitsgeschichte.  
 */  
public class Groom implements Actor {
    
    private final Name name;
    
    public Groom(String name) {
        this.name = new Name(name);
    }
    
    @Override
    public Name name() {
        return name;
    }
    
    @Override
    public void perform() {
        System.out.println("💍 " + name + " gibt sein Eheversprechen ab.");
    }
    
    /**  
     * Der Bräutigam überreicht den Ring.  
     */  
    public void giveRing() {
        System.out.println("💍 " + name + " überreicht den Trauring.");
    }

     /**
     * Der Akteur artikuliert seine Identität.
     * Er "spricht" zum Medium und übergibt seine fachlichen Details, ohne seine interne Struktur zu entblößen.
     */
    public void speak(Media media) {
        media
            .with("role", "Groom")
            .with("name", name.value())
            .with("text", "Yes, I will...");
    }
    
}