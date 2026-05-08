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
        System.out.println("🤵 " + name() + " tritt im Hochzeitsanzug auf die Bühne.");
        decoratedActor.perform();
    }

	@Override
	public void speak(Media media) {
		decoratedActor.speak(media);
	}
}