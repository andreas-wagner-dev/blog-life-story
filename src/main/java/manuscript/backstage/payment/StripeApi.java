package manuscript.backstage.payment;

/**
 * API of Stripe payment.
 */
public class StripeApi {
    
    public void execute(Transaction transaction, double amount) {
        System.out.println("💳 [Stripe API] Transaction will be executed...");
        System.out.println("💳 [Stripe API] Amount: €" + amount);
        System.out.println("💳 [Stripe API] Accounts: " + transaction.toString());
        System.out.println("💳 [Stripe API] Transaction success!");
    }
}