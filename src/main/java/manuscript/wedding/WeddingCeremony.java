package manuscript.wedding;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Scene;
import manuscript.character.Band;
import manuscript.character.Guests;

public class WeddingCeremony implements Scene {
	
    private final Actor groom;
    private final Actor bride;
    private final Scene ringExchange; // Die Zeremonie beinhaltet den Ringtausch
	private Guests guests;
	private Band band;

    public WeddingCeremony(Actor groom, Actor bride, Guests guests,Band band, Scene ringExchange) {
        this.groom = groom;
        this.bride = bride;
		this.guests = guests;
		this.band = band;
        this.ringExchange = ringExchange;
    }

    @Override
    public void execute() {
        System.out.println("\n💒 === The Wedding Ceremony Begins ===");
        
        // band play...
        band.forEach(musician -> musician.perform());
        
        // actors give their promise.
        groom.perform();
        bride.perform();
        
        // ring exchange is invoked as a sub-scene.
        ringExchange.execute();
        
        // band play and sing...
    	Media.Air voice = new Media.Air();
        band.forEach(musician -> musician.speak(voice));
		System.out.println(voice.toString());
        
		// congratulations and applause from the guest
	  	Media.Air air = new Media.Air();
        guests.forEach(guest -> guest.speak(air));
		System.out.println(air.toString());
        
        System.out.println("💒 === The marriage has been solemnized ===\n");
    }
}