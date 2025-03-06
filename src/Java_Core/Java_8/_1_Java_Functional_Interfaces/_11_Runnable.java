package Java_Core.Java_8._1_Java_Functional_Interfaces;

//✅ Represents a task that takes no arguments and returns nothing.
//✅ Used in multithreading (Thread).
public class _11_Runnable {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Task is running...");

        Thread thread = new Thread(task);
        thread.start(); // Output: Task is running...
    }
}
