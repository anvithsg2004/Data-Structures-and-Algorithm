package DSA.LLD._2_Behavioral_Design_Patterns._2_Observer;

public class EmailSubscriber implements Observer {
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received Email: " + message);
    }
}
