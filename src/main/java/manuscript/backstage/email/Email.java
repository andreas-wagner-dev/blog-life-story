package manuscript.backstage.email;

/**
 * Record to transfer email data.
 */
public class Email {

	private String from;
	private String to;
	private String content;

	public Email(String from, String to, String content) {
		this.from = from;
		this.to = to;
		this.content = content;
	}

	public String from() {
		return from;
	}

	public String to() {
		return to;
	}

	public String content() {
		return content;
	}

	@Override
	public String toString() {
		return "From: " + from + ", To: " + to + ", Text: " + content;
	}
}