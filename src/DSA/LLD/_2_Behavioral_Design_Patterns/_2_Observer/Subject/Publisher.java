package DSA.LLD._2_Behavioral_Design_Patterns._2_Observer.Subject;

import DSA.LLD._2_Behavioral_Design_Patterns._2_Observer.Observer.Subscriber;

interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers();
}
