package DSA.LLD._2_Behavioral_Design_Patterns._5_Mediator;

public class Main {
    public static void main(String[] args) {
        SimpleChatMediator mediator = new SimpleChatMediator();

        User alice = new User("Alice", mediator);
        User bob = new User("Bob", mediator);

        mediator.registerUsers(alice, bob);

        alice.send("Hi Bob!");
        bob.send("Hey Alice!");
    }
}
