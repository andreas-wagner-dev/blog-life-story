package manuscript.stage.take;

import manuscript.character.Bride;
import manuscript.character.Groom;
import manuscript.stage.Take;
import manuscript.stage.accessory.Button;
import manuscript.stage.accessory.CinematicGrid;
import manuscript.stage.accessory.SpeechBubble;
import manuscript.wedding.RingBasket;

public class WeddingCloseUp implements Take {

	private final Groom groom;
	private final Bride bride;

	private SpeechBubble groomSpeechBubble;
	private SpeechBubble brideSpeechBubble;

	private Button button;
	private CinematicGrid grid;

	public WeddingCloseUp(Groom groom, Bride bride) {
		this.groom = groom;
		this.bride = bride;
	}

	@Override
	public void render() {

		System.out.println("\n🎥 === CLOSE-UP: THE WEDDING ===");
		System.out.println("📸 Camera focuses on " + groom.name() + " and " + bride.name());
		System.out.println("🎞️ Recording tape rolling...");

		groomSpeechBubble = new SpeechBubble("Groom bubble");
		brideSpeechBubble = new SpeechBubble("Bride bubble");

		grid = new CinematicGrid();
		grid.add(groomSpeechBubble);
		grid.add(brideSpeechBubble);

		button = new Button("Perform Wedding", () -> {

			try {
				RingBasket ringBasket = new RingBasket();
				// groom.giveRing(ringBasket);
				bride.receiveRing(ringBasket);
				bride.giveRing(ringBasket);
				groom.receiveRing(ringBasket);
			} catch (Exception e) {
				// Print the trace
				e.printStackTrace();
			}

			groom.speak(groomSpeechBubble);
			bride.speak(brideSpeechBubble);

			System.out.println("📺 The image appears on the screen...");
			grid.render();

		});

	}

	public void clickOnButton() {
		System.out.println("🔘 Button clicked");
		button.click();
		System.out.println("🎥 === END OF CLOSE-UP ===\n");
	}
}