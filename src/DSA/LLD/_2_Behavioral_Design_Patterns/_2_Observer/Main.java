package DSA.LLD._2_Behavioral_Design_Patterns._2_Observer;

import DSA.LLD._2_Behavioral_Design_Patterns._2_Observer.Observer.EmailSubscriber;
import DSA.LLD._2_Behavioral_Design_Patterns._2_Observer.Observer.SmsSubscriber;
import DSA.LLD._2_Behavioral_Design_Patterns._2_Observer.Observer.Subscriber;
import DSA.LLD._2_Behavioral_Design_Patterns._2_Observer.Subject.NewsPublisher;

public class Main {
    public static void main(String[] args) {

        NewsPublisher publisher = new NewsPublisher();

        Subscriber s1 = new EmailSubscriber("Alice");
        Subscriber s2 = new SmsSubscriber("Bob");

        publisher.subscribe(s1);
        publisher.subscribe(s2);

        publisher.setNews("Breaking News: Java 21 Released!");
        // Output:
        // Alice received Email: Breaking News: Java 21 Released!
        // Bob received SMS: Breaking News: Java 21 Released!

        // Bob unsubscribes
        publisher.unsubscribe(s2);

        publisher.setNews("Update: Spring Boot 3.5 is out!");
        // Output:
        // Alice received Email: Update: Spring Boot 3.5 is out!
    }
}
