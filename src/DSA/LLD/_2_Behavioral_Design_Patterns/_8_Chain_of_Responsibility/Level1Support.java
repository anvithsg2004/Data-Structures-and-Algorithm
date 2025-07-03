package DSA.LLD._2_Behavioral_Design_Patterns._8_Chain_of_Responsibility;

public class Level1Support extends SupportHandler {
    public void handleRequest(String issue) {
        if (issue.equals("password reset")) {
            System.out.println("Level 1 handled: " + issue);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issue);
        } else {
            System.out.println("Issue not handled: " + issue);
        }
    }
}
