package manuscript.stage.accessory;

import manuscript.Media;

public class SpeechBubble extends Media.Default {

	private String text;

	public SpeechBubble() {
		this("");
	}
	
	public SpeechBubble(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
	
	public void display() {
		System.out.println("💬 [" + text + "]");
	}

	public void display(Media media) {
		System.out.println("💬 [" + media.toString() + "]");
	}

	@Override
	public Media with(String name, String value) {
		if ("text".equalsIgnoreCase(name)) {
			text = value;
		}
		return this;
	}

}