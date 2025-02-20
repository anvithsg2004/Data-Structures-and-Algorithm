package Java_Core.Multithreading._2_Synchronization.Basics;

public class Counter {

    private int id;

    //Here I have used 'synchronized'.
    //This makes filed to be shared with only one process.
    //Here, If I remove the 'synchronized' keyword, this will go into the race condition.
    public synchronized void increment() {
        id++;
    }

    public int getId() {
        return id;
    }

}
