package manuscript.stage.take;

import manuscript.character.Groom;
import manuscript.character.Bride;
import manuscript.stage.Take;
import manuscript.stage.accessory.CinematicGrid;
import manuscript.stage.accessory.SpeechBubble;

public class WeddingCloseUp implements Take {

	private final Groom groom;
	private final Bride bride;

	public WeddingCloseUp(Groom groom, Bride bride) {
		this.groom = groom;
		this.bride = bride;
	}

	@Override
	public void render() {

		System.out.println("\n🎥 === CLOSE-UP: THE WEDDING ===");

		System.out.println("📸 Camera focuses on " + groom.name() + " and " + bride.name());
		groom.perform();
		bride.perform();
		System.out.println("🎞️ Recording tape rolling...");
		SpeechBubble groomSpeechBubble = new SpeechBubble();
		groom.speak(groomSpeechBubble);
		SpeechBubble brideSpeechBubble = new SpeechBubble();
		bride.speak(brideSpeechBubble);
		System.out.println("📺 The image appears on the screen...");
		CinematicGrid grid = new CinematicGrid(groomSpeechBubble, brideSpeechBubble);
		grid.render();
		System.out.println("🎥 === END OF CLOSE-UP ===\n");
	}
}