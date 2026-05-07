package manuscript.outfit;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Outfit;
import manuscript.backstage.Payer;
import manuscript.backstage.payment.StripeApi;

public class GroomWithCard extends Outfit implements Payer {

	private StripeApi stripeApi;

	public GroomWithCard(Actor actor, StripeApi stripeApi) {
		super(actor);
		this.stripeApi = stripeApi;
	}

	@Override
	public void speak(Media spaek) {
		decoratedActor.speak(spaek);
	}

	@Override
	public void pay(double amount) {
		System.out.println("💰 " + name() + " initiiert eine Zahlung von €" + amount);
		String accountId = "stripe_account_" + name().value().toLowerCase();
		stripeApi.executeTransaction(amount, accountId);
	}
}
