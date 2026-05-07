package manuscript.backstage;

public interface Payer {
    /** Führt eine Zahlung durch. */  
    void pay(double amount);
}