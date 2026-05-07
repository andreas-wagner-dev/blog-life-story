package manuscript.outfit;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Outfit;
import manuscript.backstage.archive.DatabaseArchive;

public class PersistentActor extends Outfit {
    
    private final DatabaseArchive archive;
    
    public PersistentActor(Actor actor, DatabaseArchive archive) {
        super(actor);
        this.archive = archive;
    }
    
    @Override
    public void perform() {
        decoratedActor.perform();
        //archive.store(decoratedActor);
        System.out.println("💾 " + name() + " wurde in der Datenbank gespeichert.");
    }

	@Override
	public void speak(Media media) {
		decoratedActor.speak(media);
	}

}