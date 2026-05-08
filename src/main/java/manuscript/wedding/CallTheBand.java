package manuscript.wedding;

import manuscript.Scene;
import manuscript.outfit.GroomWithPhone;

public class CallTheBand implements Scene {
    
    private final GroomWithPhone groomWithPhone;
    private final String phoneNumber;
    
    public CallTheBand(GroomWithPhone groomWithPhone, String phoneNumber) {
        this.groomWithPhone = groomWithPhone;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void execute() {
        System.out.println("\n☎️ === DIE BAND WIRD ANGERUFEN ===");
        groomWithPhone.call(phoneNumber); 
        System.out.println("☎️ === ANRUF ABGESCHLOSSEN ===\n");
    }
}