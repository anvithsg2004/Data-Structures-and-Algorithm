package Java_Core.Multithreading._2_Synchronization._4_Static_Synchronization;

public class Printer {
    // Static synchronized method (locks the entire class)
    public static synchronized void printDocuments(String name) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " is printing document " + i);
        }
    }
}
