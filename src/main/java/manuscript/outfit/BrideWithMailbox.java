package manuscript.outfit;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Outfit;
import manuscript.backstage.email.Email;
import manuscript.backstage.email.EmailBox;
import manuscript.character.Bride;

public class BrideWithMailbox extends Outfit {

	private EmailBox emailBox;

	public BrideWithMailbox(Bride bride, EmailBox emailBox) {
		super(bride);
		this.emailBox = emailBox;
	}
	
	@Override
	public void speak(Media spaek) {
		decoratedActor.speak(spaek);
	}
	
	public void invite(Actor actor) {
		emailBox.put(new Email(name().value(), actor.name().value(), "Invitation to Wedding..."));
	}
}