package manuscript.outfit;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Outfit;
import manuscript.backstage.Payer;
import manuscript.backstage.payment.StripeApi;
import manuscript.backstage.payment.Transaction;

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
	public void pay(double amount, String toAccountId) {
		System.out.println("💰 " + name() + " Initialize payment of €" + amount);
		String groomAccountId = "stripe_account_" + name().value().toLowerCase();
		stripeApi.execute(new Transaction(groomAccountId, toAccountId), amount);
	}
}
