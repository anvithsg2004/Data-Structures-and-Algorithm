package DSA.LLD._2_Behavioral_Design_Patterns._1_Strategy;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.payBill(500);

        context.setPaymentStrategy(new UpiPayment());
        context.payBill(300);
    }
}
