package DSA.LLD._1_Creational_Design_Patterns._1_Singleton;

public class Singleton {

    private static Singleton instance;

    // Private constructor so no one can create it from outside
    private Singleton() {
        System.out.println("Singleton instance created");
    }

    // Global access point
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}
