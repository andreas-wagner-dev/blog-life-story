package manuscript;

public interface Actor {
	
    /** Name  Requisite. */
    Name name();
    
    /** Der primäre Kommunikationskanal: Die Aufforderung zum Handeln. */
    void perform();

	void speak(Media spaek);
}