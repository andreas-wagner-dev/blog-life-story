package manuscript.wedding;

import manuscript.Media;

public interface Video {
	
    /** Loads the video into memory. */  
    void load();
    
    /** Play the video. */  
	void play(Media screen);
}