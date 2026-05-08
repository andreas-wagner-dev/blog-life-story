package manuscript.backstage;

public interface Payer {
    /** Pay amount to Account. */  
    void pay(double amount, String toAccountId);
}