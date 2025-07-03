package DSA.LLD._2_Behavioral_Design_Patterns._1_Strategy;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Set strategy dynamically
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void payBill(int amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment method not set!");
        }
        paymentStrategy.pay(amount);
    }
}

