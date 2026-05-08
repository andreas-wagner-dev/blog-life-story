package manuscript.wedding;

import manuscript.Scene;
import manuscript.character.Guests;
import manuscript.outfit.BrideWithMailbox;

public class InviteTheGuests implements Scene {

	private BrideWithMailbox brideWithLetters;
	private Guests guests;

	public InviteTheGuests(BrideWithMailbox brideWithLetters, Guests guests) {
		this.brideWithLetters = brideWithLetters;
		this.guests = guests;
	}

	@Override
	public void execute() {
        System.out.println("\n☎️ === INVINTATION OF GUESTS ===");
		guests.forEach(guest -> brideWithLetters.invite(guest));
        System.out.println("☎️ === INVINTATION COMPLETED ===\n");
	}

}