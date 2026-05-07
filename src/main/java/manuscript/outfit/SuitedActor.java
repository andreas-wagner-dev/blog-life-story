package manuscript.outfit;
import manuscript.Actor;
import manuscript.Media;
import manuscript.Outfit;

public class SuitedActor extends Outfit {
    
    public SuitedActor(Actor actor) {
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