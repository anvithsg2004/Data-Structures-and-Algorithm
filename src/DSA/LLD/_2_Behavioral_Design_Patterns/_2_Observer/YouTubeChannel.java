package DSA.LLD._2_Behavioral_Design_Patterns._2_Observer;

import java.util.*;

public class YouTubeChannel implements Subject {
    private List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer o) {
        subscribers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        subscribers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : subscribers) {
            o.update(message);
        }
    }

    public void uploadVideo(String title) {
        System.out.println("Uploaded: " + title);
        notifyObservers("New Video Uploaded: " + title);
    }
}
