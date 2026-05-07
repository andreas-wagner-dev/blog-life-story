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

		System.out.println("\n🎥 === NAHAUFNAHME: DIE HOCHZEIT ===");

		System.out.println("📸 Kamera fokussiert auf " + groom.name() + " und " + bride.name());
		groom.perform();
		bride.perform();
		System.out.println("🎞️ Aufnahmeband läuft...");
		SpeechBubble groomSpeechBubble = new SpeechBubble();
		groom.speak(groomSpeechBubble);
		SpeechBubble brideSpeechBubble = new SpeechBubble();
		bride.speak(brideSpeechBubble);
		System.out.println("📺 Aufnahme erscheint auf der Leinwand...");
		CinematicGrid grid = new CinematicGrid(groomSpeechBubble, brideSpeechBubble);
		grid.render();
		System.out.println("🎥 === ENDE DER NAHAUFNAHME ===\n");
	}
}