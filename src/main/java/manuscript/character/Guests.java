package manuscript.character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Guests implements Iterable<Guest> {

	private List<Guest> guests;

	public Guests(List<Guest> guests) {
		this.guests = new ArrayList<>(guests);
	}

	@Override
	public Iterator<Guest> iterator() {
		return guests.iterator();
	}

	public Guests add(Guest guest) {
		List<Guest> newList = new ArrayList<>(guests);
		newList.add(guest);
		return new Guests(newList);
	}
}