package DSA.LLD._2_Behavioral_Design_Patterns._2_Observer;

public class Main {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Observer user1 = new EmailSubscriber("Ram");
        Observer user2 = new EmailSubscriber("Shyam");

        channel.subscribe(user1);
        channel.subscribe(user2);

        channel.uploadVideo("Observer Pattern in Java");
    }
}
