package manuscript;

public interface Actor {
	
    /** Der Name als unveränderliches Requisit. */
    Name name();
    
    /** Der primäre Kommunikationskanal: Die Aufforderung zum Handeln. */
    void perform();

	void speak(Media spaek);
}