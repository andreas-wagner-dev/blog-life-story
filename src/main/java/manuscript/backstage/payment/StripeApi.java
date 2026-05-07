package manuscript.backstage.payment;

public class StripeApi {
    
    public void executeTransaction(double amount, String accountId) {
        System.out.println("💳 [Stripe API] Transaktion wird ausgeführt...");
        System.out.println("💳 [Stripe API] Betrag: €" + amount);
        System.out.println("💳 [Stripe API] Konto: " + accountId);
        System.out.println("💳 [Stripe API] Transaktion erfolgreich!");
    }
}