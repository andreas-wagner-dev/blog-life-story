package manuscript.stage.accessory;

import manuscript.Media;

public class SpeechBubble extends Media.Default {

	private String label;

	public SpeechBubble(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return label + ": " + content.getOrDefault("text", "");
	}

}