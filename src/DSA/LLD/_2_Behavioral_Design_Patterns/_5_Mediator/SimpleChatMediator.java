package DSA.LLD._2_Behavioral_Design_Patterns._5_Mediator;

public class SimpleChatMediator implements ChatMediator {
    private User user1;
    private User user2;

    public void registerUsers(User u1, User u2) {
        this.user1 = u1;
        this.user2 = u2;
    }

    @Override
    public void sendMessage(String message, User sender) {
        if (sender == user1) {
            user2.receive(message);
        } else {
            user1.receive(message);
        }
    }
}
