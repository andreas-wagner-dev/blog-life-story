package manuscript.stage.accessory;

import manuscript.Scene;

public class ActionButton {
    
    private final String label;
    private final Scene action;
    
    public ActionButton(String label, Scene action) {
        this.label = label;
        this.action = action;
    }
    
    public void click() {
        System.out.println("🔘 Button geklickt: " + label);
        action.execute();
    }
}