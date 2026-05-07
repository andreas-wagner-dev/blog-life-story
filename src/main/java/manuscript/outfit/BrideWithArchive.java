package manuscript.outfit;

import manuscript.Media;
import manuscript.Outfit;
import manuscript.backstage.Archive;
import manuscript.backstage.archive.RecordMedia;
import manuscript.character.Bride;

public class BrideWithArchive extends Outfit {

	private Archive arhive;

	public BrideWithArchive(Bride bride, Archive arhive) {
		super(bride);
		this.arhive = arhive;
	}
	
	@Override
	public void speak(Media spaek) {
		decoratedActor.speak(spaek);
	}
	
	@Override
	public void perform() {
		//
		decoratedActor.perform();
		//
	    // Simuliere Datenbank-Speicherung
        // Das Archiv reicht dem Akteur ein leeres Blatt (RecordMedia)
        RecordMedia record = new RecordMedia();
        // Der Akteur "spricht" seine Daten auf das Blatt
        speak(record);
		arhive.store(record);
		System.out.println("💾 " + name() + " wurde in der Datenbank gespeichert.");
	}

}
