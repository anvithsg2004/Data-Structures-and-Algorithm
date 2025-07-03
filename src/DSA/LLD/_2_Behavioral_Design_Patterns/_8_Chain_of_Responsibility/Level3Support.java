package DSA.LLD._2_Behavioral_Design_Patterns._8_Chain_of_Responsibility;

public class Level3Support extends SupportHandler {
    public void handleRequest(String issue) {
        if (issue.equals("hardware failure")) {
            System.out.println("Level 3 handled: " + issue);
        } else {
            System.out.println("Issue not handled: " + issue);
        }
    }
}
