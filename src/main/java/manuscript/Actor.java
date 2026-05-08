package manuscript;

public interface Actor {
	
    /** Name  Requisite. */
    Name name();
    
    /** The call to action. */
    void perform();

    /**
     * The communication channel. 
     * @param media to speak on.
     */
	void speak(Media media);
}