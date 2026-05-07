package manuscript;

public class Name {

	private String value;

	public Name(String value) {
		if (value == null || value.trim().isEmpty()) {
			throw new IllegalArgumentException("Name darf nicht leer sein!");
		}
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	public String value() {
		return value;
	}
}
