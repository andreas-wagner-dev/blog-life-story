package manuscript.character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import manuscript.Name;

/**
 * Group of Musicians.
 */
public class Band implements Iterable<Musician> {

	private List<Musician> group;

	private final Name name;

	public Band(String name, List<Musician> group) {
		this.name = new Name(name);
		this.group = new ArrayList<>(group);
	}

	public Name name() {
		return name;
	}

	@Override
	public Iterator<Musician> iterator() {
		return group.iterator();
	}

	public Band add(Musician guest) {
		List<Musician> newList = new ArrayList<>(group);
		newList.add(guest);
		return new Band(name.value(), newList);
	}
}