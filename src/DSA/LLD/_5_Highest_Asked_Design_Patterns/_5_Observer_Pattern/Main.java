package DSA.LLD._5_Highest_Asked_Design_Patterns._5_Observer_Pattern;

import java.util.ArrayList;
import java.util.List;

// Observer
interface Observer {
    void update();
}

// Concrete Observer
class Student implements Observer {
    private String name;

    Student(String name) {
        this.name = name;
    }

    public void update() {
        System.out.println(name + " heard the bell and stood up.");
    }
}

// Subject
class Bell {
    private List<Observer> observers = new ArrayList<>();

    void addObserver(Observer o) {
        observers.add(o);
    }

    void ring() {
        System.out.println("Bell rings!");
        for (Observer o : observers) {
            o.update();
        }
    }
}

// Main
public class Main {
    public static void main(String[] args) {
        Bell bell = new Bell();

        bell.addObserver(new Student("Ram"));
        bell.addObserver(new Student("Shyam"));

        bell.ring(); // Notifies all students
    }
}
