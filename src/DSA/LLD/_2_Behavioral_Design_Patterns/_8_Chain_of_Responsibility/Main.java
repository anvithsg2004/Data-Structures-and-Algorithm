package DSA.LLD._2_Behavioral_Design_Patterns._8_Chain_of_Responsibility;

public class Main {
    public static void main(String[] args) {
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();

        level1.setNextHandler(level2);
        level2.setNextHandler(level3);

        level1.handleRequest("password reset");    // handled by Level 1
        level1.handleRequest("software bug");      // passed to Level 2
        level1.handleRequest("hardware failure");  // passed to Level 3
        level1.handleRequest("network issue");     // no one handled
    }
}
