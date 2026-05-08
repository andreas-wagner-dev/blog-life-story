package manuscript.backstage;

/**
 * Adapter to payment system.
 */
public interface Payer {
	
    /** Pay amount to account. */  
    void pay(double amount, String toAccountId);
}