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
	    // Simulate database storage
        // The Archive hands the Actor a blank sheet (RecordMedia).
        RecordMedia record = new RecordMedia();
        // The actor "speaks" his data onto the sheet.
        speak(record);
		arhive.store(record);
		System.out.println("💾 " + name() + " was saved in the database.");
	}

}
