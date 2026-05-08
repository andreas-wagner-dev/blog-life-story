package manuscript.wedding;

import manuscript.Scene;
import manuscript.backstage.Payer;
import manuscript.character.Band;

public class PayTheBand implements Scene {

	private final Payer payer;
	private final Band band;
	private final double amount;

	public PayTheBand(Payer payer, Band band, double amount) {
		this.payer = payer;
		this.band = band;
		this.amount = amount;
	}

	@Override
	public void execute() {
		System.out.println("\n🎵 === THE BAND GETS PAID ===");
		String bandAccountId = "stripe_account_" + band.name().value().toLowerCase();
		payer.pay(amount, bandAccountId);
		System.out.println("🎵 === PAYMENT COMPLETED ===\n");
	}

}