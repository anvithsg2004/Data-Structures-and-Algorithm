package DSA.LLD._2_Behavioral_Design_Patterns._2_Observer.Subject;

import DSA.LLD._2_Behavioral_Design_Patterns._2_Observer.Observer.Subscriber;

import java.util.*;

public class NewsPublisher implements Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifySubscribers();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
}
