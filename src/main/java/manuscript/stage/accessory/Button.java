package manuscript.stage.accessory;

import manuscript.Media;

public class Button extends Media.Default {
    
	private final String label;
    private final Action action;
    
    public Button(String label, Action action) {
        this.label = label;
        this.action = action;
    }
    
    public void click() {
        action.run();
    }
    
    @Override
    public String toString() {
    	return label;
    }
}