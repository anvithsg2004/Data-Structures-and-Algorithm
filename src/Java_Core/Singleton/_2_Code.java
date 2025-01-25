package Java_Core.Singleton;

class Singleton {
    // Step 1: Create a private static instance of the class
    private static volatile Singleton singleInstance = new Singleton();

    // Step 2: Make the constructor private so no one can instantiate it
    private Singleton() {}

    // Step 3: Provide a public static method to get the single instance
    public static Singleton getInstance() {

        if (singleInstance == null) {
            synchronized (Singleton.class) {
                if (singleInstance == null) {
                    System.out.println("Creating Instance.");
                    singleInstance = new Singleton();
                }
            }
        }

        return singleInstance;
    }

    // Example method
    public void showMessage() {
        System.out.println("Hello, I am the only instance!");
    }
}

public class _2_Code {
    public static void main(String[] args) {

        // Get the only instance of Singleton
        Singleton instance = Singleton.getInstance();

        // Call the method on the instance
        instance.showMessage();

    }
}
