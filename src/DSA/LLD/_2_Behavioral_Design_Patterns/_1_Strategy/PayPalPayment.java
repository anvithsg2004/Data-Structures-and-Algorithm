package DSA.LLD._2_Behavioral_Design_Patterns._1_Strategy;

public class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}
