package manuscript.wedding;

import manuscript.Media;

public interface Video {
	
    /** Lädt das Video in den Arbeitsspeicher. */  
    void load();
    
    /** Spielt das Video ab. */  
	void play(Media screen);
}