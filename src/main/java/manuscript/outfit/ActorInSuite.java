package manuscript.outfit;
import manuscript.Actor;
import manuscript.Media;
import manuscript.Outfit;

public class ActorInSuite extends Outfit {
    
    public ActorInSuite(Actor actor) {
        super(actor);
    }
    
    @Override
    public void perform() {
        System.out.println("🤵 " + name() + " steps onto the stage in a wedding suit.");
        decoratedActor.perform();
    }

	@Override
	public void speak(Media media) {
		decoratedActor.speak(media);
	}
}