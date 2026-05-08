package manuscript;

/**
 * The Movie interface is the business-level representation of the story.
 * It defines the lifecycle and the sequence of the staging.
 */
public interface Movie {

    /** Plays all loaded scenes sequentially. */  
    void play();  
}