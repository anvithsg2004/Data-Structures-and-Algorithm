package DSA.LLD._4_Problems._4_Parking_Lot.Payment_Strategy;

public class CreditCardPayment implements PaymentStrategy {
    public CreditCardPayment(double fee) {
    }
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
