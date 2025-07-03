package DSA.LLD._2_Behavioral_Design_Patterns._2_Observer;

public interface Subject {
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyObservers(String message);
}
