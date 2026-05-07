package manuscript.backstage.payment;

import manuscript.Actor;
import manuscript.Media;
import manuscript.Outfit;
import manuscript.backstage.Payer;

public class StripePayment extends Outfit implements Payer {
    
    private final StripeApi stripeApi;
    
    public StripePayment(Actor actor, StripeApi stripeApi) {
        super(actor);
        this.stripeApi = stripeApi;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("💰 " + name() + " initiiert eine Zahlung von €" + amount);
        String accountId = "stripe_account_" + name().value().toLowerCase();
        stripeApi.executeTransaction(amount, accountId);
    }

	@Override
	public void speak(Media spaek) {
		// TODO Auto-generated method stub
		
	}
}