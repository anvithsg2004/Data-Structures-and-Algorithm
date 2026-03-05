package DSA.LLD._2_Behavioral_Design_Patterns._2_Observer.Observer;

public class SmsSubscriber implements Subscriber {
    private String name;

    public SmsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received SMS: " + message);
    }
}
